package poc.ignite.closure.model;

public class SimpleInterest extends SimpleInterestParameter {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8001652822315156343L;
	
	private final Integer interest;

	public SimpleInterest(SimpleInterestParameter param, int i) {
		super(param);
		this.interest = i;
	}

	public Integer getInterest() {
		return interest;
	}

	@Override
	public String toString() {
		return "SimpleInterest [interest=" + interest + "]";
	}
	
}
