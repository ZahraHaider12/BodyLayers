package org.snomed.otf.owltoolkit.ontology;

import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLNamedObject;

public class OntologyHelper {
	public static boolean isConceptClass(final OWLClass owlClass) {
		return owlClass.getIRI().toString().startsWith(OntologyService.SNOMED_IRI);
	}

	public static long getConceptId(final OWLNamedObject owlNamedObject) {
		return Long.parseLong(owlNamedObject.getIRI().toString().substring(OntologyService.SNOMED_IRI.length()));
	}
}
