package main.client;
/**
 * Contains representations of all classes that require refreshing data
 */
public enum RefreshingClasses {
	ACC_MGR, CAT_MGR, SRC_MGR,
	TRA_EXP, TRA_INC, TRA_TRANSF, //global
	JRN, JRN_REF,
	ACC_MGR_REF, CAT_MGR_REF, SRC_MGR_REF,
	TRA_EXP_ACC, TRA_EXP_CUR, TRA_EXP_CAT, //specific (handle received data)
	TRA_INC_ACC, TRA_INC_SRC, TRA_INC_CUR, //specific (handle received data)	
	TRA_TRANSF_ACC, TRA_TRANSF_CUR, //specific (handle received data)
	BAL_ACC, BAL_CUR, BAL_AMNT //specific (handle received data)
}
