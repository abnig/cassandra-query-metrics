package poc.ignite.closure.model;

import java.io.Serializable;

public class SimpleInterestParameter implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5043745880261333626L;
	
	private final Integer principal;
	
	private final Integer rate;
	
	private final Integer time;
	

	public SimpleInterestParameter(Integer principal, Integer rate, Integer time) {
		super();
		this.principal = principal;
		this.rate = rate;
		this.time = time;
	}

	public SimpleInterestParameter(SimpleInterestParameter param) {
		this.principal = param.getPrincipal();
		this.rate = param.getRate();
		this.time = param.getTime();
	}

	public Integer getPrincipal() {
		return principal;
	}

	public Integer getRate() {
		return rate;
	}

	public Integer getTime() {
		return time;
	}

	@Override
	public String toString() {
		return "SimpleInterestParameter [principal=" + principal + ", rate=" + rate + ", time=" + time + "]";
	}
	
}
