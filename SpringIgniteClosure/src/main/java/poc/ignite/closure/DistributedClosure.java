package poc.ignite.closure;

import org.apache.ignite.lang.IgniteClosure;

import poc.ignite.closure.model.SimpleInterest;
import poc.ignite.closure.model.SimpleInterestParameter;

public class DistributedClosure implements IgniteClosure<SimpleInterestParameter, SimpleInterest>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 277119447836028372L;

	@Override
	public SimpleInterest apply(SimpleInterestParameter e) {
		System.out.println("Calculating SimpleInterest for " + e);
		return new SimpleInterest(e, ((e.getPrincipal()*e.getRate()*e.getTime())/100));
	}

}
