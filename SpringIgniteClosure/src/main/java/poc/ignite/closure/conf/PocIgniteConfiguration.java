package poc.ignite.closure.conf;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.ignite.configuration.IgniteConfiguration;
import org.apache.ignite.spi.collision.jobstealing.JobStealingCollisionSpi;
import org.apache.ignite.spi.discovery.tcp.TcpDiscoverySpi;
import org.apache.ignite.spi.discovery.tcp.ipfinder.vm.TcpDiscoveryVmIpFinder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableLoadTimeWeaving;

@EnableLoadTimeWeaving
@Configuration
public class PocIgniteConfiguration {

	@Bean
	public TcpDiscoverySpi discoverySpi(TcpDiscoveryVmIpFinder ipFinder) {
		TcpDiscoverySpi discoverySpi = new TcpDiscoverySpi();
		discoverySpi.setIpFinder(ipFinder);
		return discoverySpi;
	}

	@Bean
	public TcpDiscoveryVmIpFinder ipFinder() {
		TcpDiscoveryVmIpFinder ipFinder = new TcpDiscoveryVmIpFinder();
		Collection<String> col = new ArrayList<String>();
		col.add("localhost");
		ipFinder.setAddresses(col);
		return ipFinder;
	}
	
	@Bean
	public IgniteConfiguration igniteConfig(TcpDiscoverySpi discoverySpi, JobStealingCollisionSpi collisionSpi) {
		IgniteConfiguration igniteConfig = new IgniteConfiguration();
		igniteConfig.setActiveOnStart(true);
		igniteConfig.setClientMode(false);
		igniteConfig.setDiscoverySpi(discoverySpi);
		igniteConfig.setMetricsUpdateFrequency(100L);
		igniteConfig.setCollisionSpi(collisionSpi);
		igniteConfig.setIncludeEventTypes(getProperties());
		return igniteConfig;
	}
	
	@Bean
	public JobStealingCollisionSpi collisionSpi() {
		JobStealingCollisionSpi collisionSpi = new JobStealingCollisionSpi();
		collisionSpi.setActiveJobsThreshold(3);
		collisionSpi.setWaitJobsThreshold(1);
		collisionSpi.setMessageExpireTime(1000);
		collisionSpi.setMaximumStealingAttempts(100);
		collisionSpi.setStealingEnabled(true);
//		collisionSpi.setStealingAttributes(stealAttrs);
		return collisionSpi;

	}

	private int[] getProperties() {
		int[] arra = new int[] { org.apache.ignite.events.EventType.EVT_TASK_STARTED,
				org.apache.ignite.events.EventType.EVT_TASK_FINISHED,
				org.apache.ignite.events.EventType.EVT_TASK_FAILED,
				org.apache.ignite.events.EventType.EVT_TASK_TIMEDOUT,
				org.apache.ignite.events.EventType.EVT_TASK_SESSION_ATTR_SET,
				org.apache.ignite.events.EventType.EVT_TASK_REDUCED,

				org.apache.ignite.events.EventType.EVT_CACHE_OBJECT_PUT,
				org.apache.ignite.events.EventType.EVT_CACHE_OBJECT_READ,
				org.apache.ignite.events.EventType.EVT_CACHE_OBJECT_REMOVED };
		return arra;
	}

}