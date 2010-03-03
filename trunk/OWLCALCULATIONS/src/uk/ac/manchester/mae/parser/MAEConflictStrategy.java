/* Generated By:JJTree: Do not edit this line. MAEConflictStrategy.java */
package uk.ac.manchester.mae.parser;

public class MAEConflictStrategy extends SimpleNode {
	private String strategyName;

	public MAEConflictStrategy(int id) {
		super(id);
	}

	public MAEConflictStrategy(ArithmeticsParser p, int id) {
		super(p, id);
	}

	/** Accept the visitor. * */
	@Override
	public Object jjtAccept(ArithmeticsParserVisitor visitor, Object data) {
		return visitor.visit(this, data);
	}

	public void setStrategyName(String strategyName) {
		this.strategyName = strategyName;
	}

	public String getStrategyName() {
		return this.strategyName;
	}

	@Override
	public String toString() {
		return "$" + this.strategyName + "$";
	}

	@Override
	public boolean equals(Object obj) {
		// equals and hashcode are the same as for superclass
		return super.equals(obj);
	}

	@Override
	public int hashCode() {
		// equals and hashcode are the same as for superclass
		return super.hashCode();
	}
}