/**
 * DataConstants, Constants for DataLoader and DataWriter
 * @author Brooks Robinson
 */
package src;
public abstract class DataConstants {
    protected static final String CRIMES_FILE_NAME = "dat/crime.json";
    protected static final String CRIMES_ID = "id";
    protected static final String CRIMES_TYPE_OF_CRIME = "typeOfCrime";
    protected static final String CRIMES_CHARGE_LEVEL = "levelOfCharge";
    protected static final String CRIMES_JURISDICTION = "jurisdiction";
    protected static final String CRIMES_IS_OPEN = "isOpen";
    protected static final String CRIMES_AUTHOR = "author";
    protected static final String CRIMES_LOCATION = "location";
    protected static final String CRIMES_POI = "poi";
    protected static final String CRIMES_SUSPECTS = "suspects";
    protected static final String CRIMES_CRIMINALS = "criminals";
    protected static final String CRIMES_VICTIMS = "victims";
    protected static final String CRIMES_WITNESSES = "witnesses";
    protected static final String CRIMES_OFFICERS = "officers";
    protected static final String CRIMES_EVIDENCE = "evidence";

    protected static final String CRIMINAL_FILE_NAME = "dat/criminal.json";
    protected static final String CRIMINAL_CRIMES = "crimes";
    protected static final String CRIMINAL_SENTENCE = "sentence";
    protected static final String CRIMINAL_STATUS = "status";
    protected static final String CRIMINAL_IN_CUSTODY = "inCustody";

    protected static final String EVIDENCE_FILE_NAME = "dat/evidence.json";
    protected static final String EVIDENCE_ID = "id";
    protected static final String EVIDENCE_DESCRIPTION = "description";
    protected static final String EVIDENCE_DISC_DATE = "discdate";

    protected static final String OFFICER_FILE_NAME = "dat/officer.json";
    protected static final String OFFICER_TYPE = "typeOfficer";
    protected static final String OFFICER_STATEMENT = "statement";

    protected static final String PERSON_FILE_NAME = "dat/person.json";
    protected static final String PERSON_FIRST_NAME = "firstName";
    protected static final String PERSON_LAST_NAME = "lastName";
    protected static final String PERSON_ID = "id";
    protected static final String PERSON_GENDER = "gender";
    protected static final String PERSON_RACE = "race";
    protected static final String PERSON_HAIR_COLOR = "hairColor";
    protected static final String PERSON_HAIR_STYLE = "hairStyle";
    protected static final String PERSON_EYE_COLOR = "eyeColor";
    protected static final String PERSON_ADDRESS = "address";
    protected static final String PERSON_AGE = "age";

    protected static final String POI_FILE_NAME = "dat/poi.json";
    protected static final String POI_TATTOOS = "tattoos";
    protected static final String POI_GANG = "gang";
    protected static final String POI_VICTIM_RELATION = "victimRelation";
    protected static final String POI_EVIDENCE_CONN = "evidenceConn";
    protected static final String POI_IS_REPEAT_OFFENDER = "isRepeatOffender";

    protected static final String HOSPITAL_FILE_NAME = "dat/hospital.json";
    protected static final String HOSPITAL_ID = "id";
    protected static final String HOSPITAL_DIAGNOSIS = "diagnosis";
    protected static final String HOSPITAL_CAUSE = "cause";
    protected static final String HOSPITAL_DOCTOR = "doctor";
    protected static final String HOSPITAL_NURSE = "nurse";
    protected static final String HOSPITAL_DATE = "date";
    protected static final String HOSPITAL_NUM_DAYS = "numDays";

    protected static final String SUSPECT_FILE_NAME = "dat/suspect.json";
    protected static final String SUSPECT_ACCOMPLICES = "accomplices";
    protected static final String SUSPECT_FAMILY_MEMBERS = "familyMembers";
    protected static final String SUSPECT_FOOT_SIZE = "footSize";
    protected static final String SUSPECT_PREFERRED_CLOTHES = "prefClothes";
    protected static final String SUSPECT_NICKNAMES = "nicknames";
    protected static final String SUSPECT_COMMON_WORDS = "commonWords";
    protected static final String SUSPECT_HOBBIES = "hobbies";
    protected static final String SUSPECT_JOB = "job";
    protected static final String SUSPECT_PHYSICAL_TRAITS = "physTraits";

    protected static final String USER_FILE_NAME = "dat/user.json";
    protected static final String USER_ACCESS_LEVEL = "accessLevel";
    protected static final String USER_FIRST_NAME = "firstName";
    protected static final String USER_LAST_NAME = "lastName";
    protected static final String USER_USERNAME ="userName";
    protected static final String USER_PASSWORD = "userPassword";
    
    protected static final String VICTIM_FILE_NAME = "dat/victim.json";
    protected static final String VICTIM_STATEMENT = "statement";
    protected static final String VICTIM_IS_ALIVE = "isAlive";
    protected static final String VICTIM_H_REPORTS = "hReports";

    protected static final String WITNESS_FILE_NAME = "dat/witness.json";
    protected static final String WITNESS_PHONE_NUMBER = "phone";
    protected static final String WITNESS_EMAIL = "email";
    protected static final String WITNESS_STATEMENT = "statement";
    protected static final String WITNESS_RELATION_BAD = "relBad";
}