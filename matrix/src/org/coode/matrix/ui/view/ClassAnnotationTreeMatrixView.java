package org.coode.matrix.ui.view;

import org.coode.matrix.model.api.AbstractTreeMatrixModel;
import org.coode.matrix.model.impl.ClassAnnotationTreeMatrixModel;
import org.coode.matrix.model.parser.OWLObjectListParser;
import org.coode.matrix.ui.renderer.OWLObjectTreeTableCellRenderer;
import org.protege.editor.owl.model.hierarchy.OWLObjectHierarchyProvider;
import org.semanticweb.owl.model.OWLClass;

import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableCellEditor;
import java.net.URI;

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
 * Date: Jul 3, 2007<br><br>
 */
public class ClassAnnotationTreeMatrixView extends AbstractTreeMatrixView<OWLClass> {

    protected boolean isOWLClassView() {
        return true;
    }

    protected OWLObjectHierarchyProvider<OWLClass> getHierarchyProvider() {
        return getOWLModelManager().getOWLClassHierarchyProvider();
    }

    protected AbstractTreeMatrixModel<OWLClass> createMatrixModel(OWLObjectTreeTableCellRenderer<OWLClass> tree) {
        return new ClassAnnotationTreeMatrixModel(tree, getOWLModelManager());
    }

    protected void initialiseMatrixView() throws Exception {
    }


    protected TableCellEditor getCellEditor(Object columnObject, OWLClass rowObject) {
        setEditorType(OWLObjectListParser.DATATYPE);
        return super.getCellEditor(columnObject, rowObject);
    }
}