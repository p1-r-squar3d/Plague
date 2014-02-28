package plague.client.pathogen.symptom;

import cpw.mods.fml.common.registry.LanguageRegistry;

public class PathogenSymptoms {

SymptomTier1 symp1;
SymptomTier2 symp2;
SymptomTier3 symp3;
SymptomTier4 symp4;
SymptomTier5 symp5;

String sympName;
String sympDesc;

public void getSymptomsT1() {
	switch(symp1) {
	case NAUSEA:
		reg("Nausea", "Makes you sick");
		break;
	case ANAEMIA:
		reg("Anemia", "Bloop");
		break;
	case COUGHING:
		reg("Coughing", "Stub");
		break;
	case CYSTS:
		break;
	case INSOMNIA:
		break;
	case RASH:
		break;
	default:
		break;
	}
}

public void getSymptomsT2() {
	switch(symp2) {
	case ABSCESSES:
		break;
	case HEMOPHILIA:
		break;
	case HYPER_SENSITIVITY:
		break;
	case PARANOIA:
		break;
	case PNEUMONIA:
		break;
	case SNEEZING:
		break;
	case SWEATING:
		break;
	case VOMITING:
		break;
	default:
		break;
	}
}

public void getSymptomsT3() {
	switch(symp3) {
	case DIARRHEA:
		break;
	case FEVER:
		break;
	case INFLAMMATION:
		break;
	case INTERNAL_HEMORRHAGING:
		break;
	case PULMONARY_ODEMA:
		break;
	case SEIZURES:
		break;
	case SKIN_LESIONS:
		break;
	case TUMORS:
		break;
	default:
		break;
	}
}

public void getSymptomsT4() {
	switch(symp4) {
	case DYSENTERY:
		break;
	case HEMORRHAGIC_SHOCK:
		break;
	case IMMUNE_SUPPRESSION:
		break;
	case INSANITY:
		break;
	case NECROSIS:
		break;
	case PARALYSIS:
		break;
	case PULMONARY_FIBROSIS:
		break;
	case SYSTEMIC_INFECTION:
		break;
	default:
		break;
	}
}

public void getSymptomsT5() {
	switch(symp5) {
	case COMA:
		break;
	case TOTAL_ORGAN_FAILURE:
		break;
	default:
		break;
	}
}
public void reg(String n, String d) {
	LanguageRegistry.instance().addStringLocalization("symptom." + n, "en_US", d);
}
}