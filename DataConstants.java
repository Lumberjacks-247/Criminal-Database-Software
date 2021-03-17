public abstract class DataConstants {
    protected static final String CRIMES_FILE_NAME = "dat/crimes.json";
    protected static final String CRIMES_ID = "id";
    protected static final String CRIMES_CRIME = "crime";
    protected static final String CRIMES_NUM_CRIMINALS = "numCriminals";
    protected static final String CRIMES_CRIMINALS = "criminals";
    protected static final String CRIMES_NUM_VICTIMS = "numVictims";
    protected static final String CRIMES_VICTIMS = "victims";
    protected static final String CRIMES_NUM_POI = "numPOI";
    protected static final String CRIMES_POI = "poi";
    protected static final String CRIMES_NUM_WITNESSES = "numWitnesses";
    protected static final String CRIMES_WITNESSES = "witnesses";
    protected static final String CRIMES_NUM_SUSPECTS = "numSuspects";
    protected static final String CRIMES_SUSPECTS = "suspects";
    protected static final String CRIMES_NUM_EVIDENCE = "numEvidence";
    protected static final String CRIMES_EVIDENCE = "evidence";
    protected static final String CRIMES_NUM_REPORTS = "numReports";
    protected static final String CRIMES_REPORTS = "reports";

    protected static final String CRIMINAL_FILE_NAME = "dat/criminal.json";
    protected static final String CRIMINAL_NUM_CRIMES = "numCrimes";
    protected static final String CRIMINAL_ASSOC_CRIMES = "associatedCrimes";
    protected static final String CRIMINAL_IS_VIOLENT = "isViolent";
    protected static final String CRIMINAL_GANG = "gang";
    protected static final String CRIMINAL_SHOE_SIZE = "shoeSize";
    protected static final String CRIMINAL_NUM_TATTOOS = "numTattoos";
    protected static final String CRIMINAL_TATTOOS = "tattoos";

    protected static final String EVIDENCE_FILE_NAME = "dat/evidence.json";
    protected static final String EVIDENCE_ID = "id";
    protected static final String EVIDENCE_NAME = "name";
    protected static final String EVIDENCE_LOCATION = "location";
    protected static final String EVIDENCE_HAS_DNA = "hasDNA";
    protected static final String EVIDENCE_ASSOC_CRIME = "associatedCrime";
    protected static final String EVIDENCE_DATE_COLLECTED = "dateCollected";

    protected static final String OFFICER_FILE_NAME = "dat/officer.json";
    protected static final String OFFICER_ID = "id";
    protected static final String OFFICER_BADGE_NO = "badgeNo";
    protected static final String OFFICER_NUM_CRIMES = "numCrimes";
    protected static final String OFFICER_ASSOC_CRIMES = "associatedCrimes";

    protected static final String PERSON_FILE_NAME = "dat/person.json";
    protected static final String PERSON_ID = "id";
    protected static final String PERSON_FIRST_NAME = "firstName";
    protected static final String PERSON_LAST_NAME = "lastName";
    protected static final String PERSON_SEX = "sex";
    protected static final String PERSON_BIRTHDAY = "birthday";
    protected static final String PERSON_HEIGHT_FT = "heightFt";
    protected static final String PERSON_HEIGHT_IN = "heightIn";
    protected static final String PERSON_WEIGHT = "weight";
    protected static final String PERSON_IS_JUVENILE = "isJuvenile";
    protected static final String PERSON_ADDRESS = "address";
    protected static final String PERSON_CITY = "city";
    protected static final String PERSON_STATE = "state";
    protected static final String PERSON_ZIP = "zip";
    protected static final String PERSON_EYE_COLOR = "eyeColor";
    protected static final String PERSON_RACE = "race";

    protected static final String POI_FILE_NAME = "dat/poi.json";
    protected static final String POI_ID = "id";
    protected static final String POI_NUM_CRIMES = "numCrimes";
    protected static final String POI_ASSOC_CRIMES = "associatedCrimes";
    protected static final String POI_PHONE = "phone";

    protected static final String REPORT_FILE_NAME = "dat/report.json";
    protected static final String REPORT_ID = "RepID";
    protected static final String REPORT_NUM_STATEMENTS = "NumStatements";
    protected static final String REPORT_STATEMENTS = "Statements";
    protected static final String REPORT_NUM_VICTIMS = "NumVictims";
    protected static final String REPORT_VICTIMS = "Victims";

    protected static final String SUSPECTS_FILE_NAME = "dat/suspects.json";
    protected static final String SUSPECTS_ID = "id";
    protected static final String SUSPECTS_NUM_CRIMES = "numCrimes";
    protected static final String SUSPECTS_ASSOC_CRIMES = "associatedCrimes";
    protected static final String SUSPECTS_IS_PAST_CRIMINAL = "isPastCriminal";
    protected static final String SUSPECTS_PHONE = "phone";
    protected static final String SUSPECTS_NUM_TATTOOS = "numTattoos";
    protected static final String SUSPECTS_TATTOOS = "tattoos";
    protected static final String SUSPECTS_SHOE_SIZE = "shoeSize";
    protected static final String SUSPECTS_GANG = "gang";

    protected static final String USER_FILE_NAME = "dat/user.json";
    protected static final String USER_ACCESS_LEVEL = "accessLevel";
    protected static final String USER_FIRST_NAME = "firstName";
    protected static final String USER_LAST_NAME = "lastName";

    protected static final String VICTIM_FILE_NAME = "dat/victim.json";
    protected static final String VICTIM_ID = "id";
    protected static final String VICTIM_NUM_H_REPORTS = "numHReports";
    protected static final String VICTIM_HOSPITAL_REPORTS = "hospitalReports";
    protected static final String VICTIM_NUM_CRIMES = "numCrimes";
    protected static final String VICTIM_CRIMES = "crimes";

    protected static final String WITNESS_FILE_NAME = "dat/witness.json";
    protected static final String WITNESS_ID = "id";
    protected static final String WITNESS_NUM_CRIMES = "numCrimes";
    protected static final String WITNESS_ASSOC_CRIMES = "associatedCrimes";
    protected static final String WITNESS_PHONE = "phone";
}
