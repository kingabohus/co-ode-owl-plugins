package org.coode.cloud.view;

import org.coode.cloud.model.AbstractClassCloudModel;
import org.coode.cloud.model.OWLCloudModel;
import org.protege.editor.owl.model.OWLModelManager;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLException;
import org.semanticweb.owlapi.model.OWLOntology;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.util.Set;

/*
 * Copyright (C) 2007, University of Manchester
 *
 * Modifications to the initial code base are copyright of their
 * respective authors, or their employers as appropriate.  Authorship
 * of the modifications may be determined from the ChangeLog placed at
 * the end of this file.
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.

 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.

 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301  USA
 */

/**
 * Author: Nick Drummond<br>
 * http://www.cs.man.ac.uk/~drummond<br><br>
 * <p/>
 * The University Of Manchester<br>
 * Bio Health Informatics Group<br>
 * Date: Sep 26, 2006<br><br>
 * <p/>
 */
public class ClassInterestingness extends AbstractClassCloudView {

	private static final long serialVersionUID = 6134752150563492815L;

	private JSlider slider;

    private int definedClassWeight = 2;

    private ChangeListener sliderListener = new ChangeListener() {
        public void stateChanged(ChangeEvent changeEvent) {
            definedClassWeight = slider.getValue();
            getCloudComponent().refill();
        }
    };

    public void initialiseView() throws Exception {
        super.initialiseView();

        JPanel c = new JPanel();
        c.setLayout(new BoxLayout(c, BoxLayout.LINE_AXIS));
        slider = new JSlider(0, 100);
        slider.setValue(definedClassWeight);
        slider.addChangeListener(sliderListener);
        slider.setToolTipText("Defined Class Weighting");

//        c.add(new JLabel(Icons.getIcon("filter.remove.png")));
        c.add(slider);
//        c.add(new JLabel(Icons.getIcon("filter.add.png")));

        getSliderPanel().add(c);
    }

    protected OWLCloudModel createModel() {
        return new ClassInterestingness.ClassInterestingnessModel(getOWLModelManager());
    }

    class ClassInterestingnessModel extends AbstractClassCloudModel {

        protected ClassInterestingnessModel(OWLModelManager mngr) {
            super(mngr);
        }

        public void activeOntologiesChanged(Set<OWLOntology> ontologies) {
        }

        protected int getValueForEntity(OWLClass entity) throws OWLException {
            int restrictionCount = 0;
            int definedClassBonus = 0;
            int usage = 0;
            for (OWLOntology ont : getOWLModelManager().getActiveOntologies()){
                restrictionCount += entity.getSuperClasses(ont).size();
                definedClassBonus = definedClassWeight * entity.getEquivalentClasses(ont).size();
                usage += ont.getReferencingAxioms(entity).size();
            }
            return restrictionCount + usage + definedClassBonus;
        }
    }
}
