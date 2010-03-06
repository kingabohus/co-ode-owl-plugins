package org.coode.oppl.variablemansyntax.generated;

import java.net.URI;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.coode.oppl.variablemansyntax.ConstraintSystem;
import org.coode.oppl.variablemansyntax.ManchesterVariableSyntax;
import org.coode.oppl.variablemansyntax.PlainVariableVisitor;
import org.coode.oppl.variablemansyntax.VariableScope;
import org.coode.oppl.variablemansyntax.VariableScopeChecker;
import org.coode.oppl.variablemansyntax.VariableType;
import org.coode.oppl.variablemansyntax.VariableTypeVisitorEx;
import org.coode.oppl.variablemansyntax.VariableVisitor;
import org.coode.oppl.variablemansyntax.bindingtree.BindingNode;
import org.semanticweb.owl.inference.OWLReasonerException;
import org.semanticweb.owl.model.OWLEntity;
import org.semanticweb.owl.model.OWLObject;

public class RegExpGeneratedVariable implements
		GeneratedVariable<Collection<OWLEntity>> {
	private final String name;
	private final VariableType type;
	private RegExpGeneratedValue value;

	public RegExpGeneratedVariable(String name, VariableType type,
			ConstraintSystem cs, RegExpGeneratedValue exp) {
		this.name = name;
		this.type = type;
		this.value = exp;
	}

	public String getOPPLFunction() {
		return "Match(" + this.value + ")";
	}

	public String getArgumentString() {
		return this.value.toString();
	}

	protected OWLObject generateObject(OWLEntity v) {
		return v;
	}

	public <P> P accept(VariableVisitor<P> visitor) {
		return visitor.visit(this);
	}

	public void accept(PlainVariableVisitor visitor) {
		visitor.visit(this);
	}

	public boolean addPossibleBinding(OWLObject object)
			throws OWLReasonerException {
		return false;
	}

	public void clearBindings() {
	}

	public OWLEntity getGeneratedOWLObject(BindingNode bindingNode) {
		Collection<OWLEntity> entities = this.value
				.getGeneratedValue(bindingNode);
		//XXX this requires a single result but it's really a set
		if (entities.size() > 0) {
			return entities.iterator().next();
		}
		return null;
	}

	public String getName() {
		return this.name;
	}

	public Set<OWLObject> getPossibleBindings() {
		return Collections.<OWLObject> unmodifiableSet(new HashSet<OWLEntity>(
				this.value.computePossibleValues().get(0)));
	}

	public VariableType getType() {
		return this.type;
	}

	public URI getURI() {
		String fragment = this.name.substring(this.name.indexOf('?') + 1);
		return URI.create(ManchesterVariableSyntax.NAMESPACE + fragment);
	}

	public RegExpGeneratedValue getValue() {
		return this.value;
	}

	public VariableScope getVariableScope() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean removePossibleBinding(OWLObject object) {
		return false;
	}

	public void setValue(GeneratedValue<Collection<OWLEntity>> value) {
		this.value = (RegExpGeneratedValue) value;
	}

	public void setVariableScope(VariableScope variableScope,
			VariableScopeChecker variableScopeChecker) {
		// TODO Auto-generated method stub
	}

	public <P> GeneratedVariable<P> replaceValue(GeneratedValue<P> replaceValue) {
		return null;
	}

	public <P> P accept(VariableTypeVisitorEx<P> visitor) {
		return visitor.visit(this);
	}

	@Override
	public String toString() {
		return this.name + ":" + this.type + "=" + this.getOPPLFunction();
	}
}
