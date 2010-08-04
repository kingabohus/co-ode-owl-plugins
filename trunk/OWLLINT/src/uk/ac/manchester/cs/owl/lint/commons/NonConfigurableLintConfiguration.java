/**
 * 
 */
package uk.ac.manchester.cs.owl.lint.commons;

import java.util.Collections;
import java.util.Set;

import org.semanticweb.owl.lint.configuration.LintConfiguration;
import org.semanticweb.owl.lint.configuration.LintConfigurationVisitor;
import org.semanticweb.owl.lint.configuration.LintConfigurationVisitorEx;

/**
 * Simple Configuration for those Lint that will not be configurable from
 * outside.
 * 
 * @author Luigi Iannone
 * 
 */
public class NonConfigurableLintConfiguration implements LintConfiguration {
	private final static NonConfigurableLintConfiguration instance = new NonConfigurableLintConfiguration();

	private NonConfigurableLintConfiguration() {
	}

	/**
	 * @see org.semanticweb.owl.lint.configuration.LintConfiguration#accept(org.semanticweb.owl.lint.configuration.LintConfigurationVisitor)
	 */
	public void accept(LintConfigurationVisitor visitor) {
		visitor.visitNonConfigurableLintConfiguration(this);
	}

	/**
	 * @see org.semanticweb.owl.lint.configuration.LintConfiguration#accept(org.semanticweb.owl.lint.configuration.LintConfigurationVisitorEx)
	 */
	public <P> P accept(LintConfigurationVisitorEx<P> visitor) {
		return visitor.visitNonConfigurableLintConfiguration(this);
	}

	/**
	 * @return the instance
	 */
	public static NonConfigurableLintConfiguration getInstance() {
		return instance;
	}

	public Set<String> getPropertyKeys() {
		return Collections.emptySet();
	}

	public String getPropertyValue(String key) {
		// Just to obey to the interface specification.
		if (key == null) {
			throw new NullPointerException("The key cannot be null");
		}
		return null;
	}

	public void setProperty(String key, String value) {
		if (key == null) {
			throw new NullPointerException("The key cannot be null");
		}
	}
}