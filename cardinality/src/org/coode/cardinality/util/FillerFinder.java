package org.coode.cardinality.util;

import org.semanticweb.owlapi.model.*;
import org.semanticweb.owlapi.util.OWLObjectVisitorAdapter;
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
 * http://www.cs.man.ac.uk/~drummond/<br><br>
 * <p/>
 * The University Of Manchester<br>
 * Bio Health Informatics Group<br>
 * Date: Sep 4, 2007<br><br>
 */
public class FillerFinder extends OWLObjectVisitorAdapter {

    private OWLObject filler;

    public OWLObject getFiller(OWLClassExpression owlRestr) {
        filler = null;
        owlRestr.accept(this);
        return filler;
    }

    public void visit(OWLObjectSomeValuesFrom desc) {
        filler = desc.getFiller();
    }

    public void visit(OWLObjectAllValuesFrom desc) {
        filler = desc.getFiller();
    }

    public void visit(OWLObjectHasValue desc) {
        filler = desc.getValue();
    }

    public void visit(OWLObjectMinCardinality desc) {
        filler = desc.getFiller();
    }

    public void visit(OWLObjectExactCardinality desc) {
        filler = desc.getFiller();
    }

    public void visit(OWLObjectMaxCardinality desc) {
        filler = desc.getFiller();
    }

    public void visit(OWLDataSomeValuesFrom desc) {
        filler = desc.getFiller();
    }

    public void visit(OWLDataAllValuesFrom desc) {
        filler = desc.getFiller();
    }

    public void visit(OWLDataHasValue desc) {
        filler = desc.getValue();
    }

    public void visit(OWLDataMinCardinality desc) {
        filler = desc.getFiller();
    }

    public void visit(OWLDataExactCardinality desc) {
        filler = desc.getFiller();
    }

    public void visit(OWLDataMaxCardinality desc) {
        filler = desc.getFiller();
    }

    public void visit(OWLObjectComplementOf desc) {
         desc.getOperand().accept(this);
    }
}
