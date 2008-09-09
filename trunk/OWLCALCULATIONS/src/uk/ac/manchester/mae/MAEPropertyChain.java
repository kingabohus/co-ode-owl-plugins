/* Generated By:JJTree: Do not edit this line. MAEPropertyChain.java */
package uk.ac.manchester.mae;

public class MAEPropertyChain extends SimpleNode {
	private String propertyName;
	private int index = -1;
	private boolean isEnd = true;

	public MAEPropertyChain(int id) {
		super(id);
	}

	public MAEPropertyChain(ArithmeticsParser p, int id) {
		super(p, id);
	}

	/** Accept the visitor. * */
	@Override
	public Object jjtAccept(ArithmeticsParserVisitor visitor, Object data) {
		return visitor.visit(this, data);
	}

	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}

	public String getPropertyName() {
		return this.propertyName;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public int getIndex() {
		return this.index;
	}

	public void setEnd(boolean b) {
		this.isEnd = b;
	}

	public boolean isEnd() {
		return this.isEnd;
	}

	@Override
	public String toString() {
		String toReturn = this.propertyName;
		boolean hasFacet = false;
		Node facet = null;
		for (int i = 0; i < this.jjtGetNumChildren() && !hasFacet; i++) {
			facet = this.children[i];
			hasFacet = facet instanceof MAEPropertyFacet;
		}
		if (hasFacet) {
			toReturn += facet.toString();
		}
		if (!this.isEnd) {
			boolean found = false;
			Node child = null;
			for (int i = 0; i < this.jjtGetNumChildren() && !found; i++) {
				child = this.children[i];
				found = child instanceof MAEPropertyChain;
			}
			if (found) {
				toReturn += "!" + child.toString();
			}
		}
		return toReturn;
	}
}