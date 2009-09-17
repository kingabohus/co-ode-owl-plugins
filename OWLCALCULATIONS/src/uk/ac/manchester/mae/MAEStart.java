/* Generated By:JJTree: Do not edit this line. MAEStart.java */
package uk.ac.manchester.mae;


public class MAEStart extends SimpleNode {
	public MAEStart(int id) {
		super(id);
	}

	public MAEStart(ArithmeticsParser p, int id) {
		super(p, id);
	}

	/** Accept the visitor. * */
	@Override
	public Object jjtAccept(ArithmeticsParserVisitor visitor, Object data) {
		return visitor.visit(this, data);
	}

	@Override
	public String toString() {
		String toString = "";
		Node previousChild = null;
		for (Node child : this.children) {
			boolean isLastBinding = previousChild != null
					&& previousChild instanceof MAEBinding
					&& !(child instanceof MAEBinding);
			if (isLastBinding) {
				toString += "->";
			}
			if (child instanceof MAEStoreTo) {
				toString += " STORETO <" + child.toString() + ">";
			} else if (child instanceof MAEmanSyntaxClassExpression) {
				toString += " APPLIESTO <" + child.toString() + ">";
			} else {
				toString += " " + child.toString();
			}
			previousChild = child;
		}
		return toString + ";";
	}
}
