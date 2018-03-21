package poc.ignite.closure;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.ignite.Ignite;
import org.apache.ignite.Ignition;
import org.apache.ignite.configuration.IgniteConfiguration;
import org.apache.ignite.lang.IgniteFuture;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import poc.ignite.closure.conf.PocIgniteConfiguration;
import poc.ignite.closure.model.SimpleInterest;
import poc.ignite.closure.model.SimpleInterestParameter;

public class MainRunner {

	public static void main(String... args) {
		AnnotationConfigApplicationContext app = new AnnotationConfigApplicationContext(PocIgniteConfiguration.class);
		IgniteConfiguration igniteConfig = app.getBean(IgniteConfiguration.class);
		Collection<SimpleInterest> res = null;
		try (Ignite ignite = Ignition.start(igniteConfig)) {
			System.out.println("Started Ignite Cluster");
			IgniteFuture<Collection<SimpleInterest>> igniteFuture = ignite.compute()
					.applyAsync(new DistributedClosure(), createParamCollection());
			res = igniteFuture.get();
		}

		System.out.println(res);
		app.close();
	}

	private static List<SimpleInterestParameter> createParamCollection() {
		List<SimpleInterestParameter> list = new ArrayList<>();
		for (int i = 0; i < 2000; i++) {
			SimpleInterestParameter p = new SimpleInterestParameter((int) (Math.random() * 1000), 5, 5);
			list.add(p);
		}
		return list;
	}

}
