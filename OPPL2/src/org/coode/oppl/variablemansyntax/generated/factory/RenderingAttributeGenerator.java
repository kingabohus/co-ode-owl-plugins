package org.coode.oppl.variablemansyntax.generated.factory;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.coode.oppl.entity.OWLEntityRenderer;
import org.coode.oppl.syntax.OPPLParser;
import org.coode.oppl.variablemansyntax.ConstraintSystem;
import org.coode.oppl.variablemansyntax.Variable;
import org.coode.oppl.variablemansyntax.generated.VariableGeneratedValue.AttributeGenerator;
import org.semanticweb.owl.model.OWLEntity;
import org.semanticweb.owl.model.OWLObject;

final class RenderingAttributeGenerator implements AttributeGenerator<String> {
	private final OWLEntityRenderer entityRenderer;
	private static RenderingAttributeGenerator instance = null;
	private ConstraintSystem constraintSystem;

	private RenderingAttributeGenerator(ConstraintSystem cs) {
		assert cs != null;
		this.constraintSystem = cs;
		this.entityRenderer = OPPLParser.getOPPLFactory().getOWLEntityRenderer(
				this.constraintSystem);
	}

	protected static RenderingAttributeGenerator getInstance(ConstraintSystem cs) {
		if (instance == null) {
			instance = new RenderingAttributeGenerator(cs);
		}
		return instance;
	}

	public String getValue(OWLObject object) {
		String toReturn = null;
		if (object instanceof OWLEntity) {
			toReturn = this.entityRenderer.render((OWLEntity) object);
		} else {
			toReturn = object.toString();
		}
		return toReturn;
	}

	public List<String> getValues(Variable variable) {
		List<String> toReturn = new ArrayList<String>();
		Set<OWLObject> possibleBindings = variable.getPossibleBindings();
		for (OWLObject object : possibleBindings) {
			if (object instanceof OWLEntity) {
				toReturn.add(this.entityRenderer.render((OWLEntity) object));
			} else {
				toReturn.add(object.toString());
			}
		}
		return toReturn;
	}
}