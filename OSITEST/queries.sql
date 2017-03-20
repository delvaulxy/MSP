FILTER FIL_ONE
INSERT INTO 
 CSS05FF01T
 (CURRENCY_CODE,TARGET_CURRENCY_CODE,EXCHANGE_DATE,EXCHANGE_RATE,RUN_ID)
  SELECT 
 (S.CUSTOMER_ID, S.IPS_CUSTOMER_ID_NUM, S.INDUSTRY_ID, S.YEAR_ID1, S.RUN_ID)
  FROM TGT_FIL_ONE S 
  WHERE 
 TRUE
 
JOINER JNR_TRANSONE
INSERT INTO 
 TGT_FIL_ONE
 (CUSTOMER_ID,IPS_CUSTOMER_ID_NUM,INDUSTRY_ID,CLAIM_ID,CLAIM_DESC,LOB_ID,COUNTRY_ID,TYPE_OF_EVENT_ID1,TYPE_OF_VEHICLE1,TYPE_OF_COVERAGE1,CLAIM_STATUS_ID1,CONTRACT_ID1,PROGRAM_ID1,YEAR_ID1,INSURED_F1,TOTAL_VEHICLES_F_OD1,TOTAL_VEHICLES_F_TPL1,RUN_ID1,CUSTOMER_ID3,IPS_CUSTOMER_ID_NUM3,INDUSTRY_ID3,CLAIM_ID3,CLAIM_DESC3,LOB_ID3,COUNTRY_ID3,TYPE_OF_EVENT_ID3,TYPE_OF_VEHICLE3,TYPE_OF_COVERAGE3,CLAIM_STATUS_ID3,CONTRACT_ID3,PROGRAM_ID3,YEAR_ID3,INSURED_F3,TOTAL_VEHICLES_F_OD3,TOTAL_VEHICLES_F_TPL3,RUN_ID3,CLAIM_ID1,CLAIM_DESC1,RUN_ID)
  SELECT 
 (D.CUSTOMER_ID, D.IPS_CUSTOMER_ID_NUM, D.INDUSTRY_ID, D.CLAIM_ID, D.CLAIM_DESC, D.LOB_ID, D.COUNTRY_ID, D.TYPE_OF_EVENT_ID1, D.TYPE_OF_VEHICLE1, D.TYPE_OF_COVERAGE1, D.CLAIM_STATUS_ID1, D.CONTRACT_ID1, D.PROGRAM_ID1, D.YEAR_ID1, D.INSURED_F1, D.TOTAL_VEHICLES_F_OD1, D.TOTAL_VEHICLES_F_TPL1, D.RUN_ID1, D.CUSTOMER_ID3, D.IPS_CUSTOMER_ID_NUM3, D.INDUSTRY_ID3, D.CLAIM_ID3, D.CLAIM_DESC3, D.LOB_ID3, D.COUNTRY_ID3, D.TYPE_OF_EVENT_ID3, D.TYPE_OF_VEHICLE3, D.TYPE_OF_COVERAGE3, D.CLAIM_STATUS_ID3, D.CONTRACT_ID3, D.PROGRAM_ID3, D.YEAR_ID3, D.INSURED_F3, D.TOTAL_VEHICLES_F_OD3, D.TOTAL_VEHICLES_F_TPL3, D.RUN_ID3, M.CLAIM_ID1, M.CLAIM_DESC1, M.RUN_ID,)
  FROM 
 TGT_JNR_TRANSONE M  INNER JOIN 
TGT_JNR_TRANSONE D 
ON
M.CLAIM_ID1 = D.CUSTOMER_ID
 
SOURCE QUALIFIERSQ_GCT20F096T
INSERT INTO 
 TGT_JNR_TRANSONE
 (CLAIM_ID1,CLAIM_DESC1,RUN_ID)
  SELECT 
(S.CLAIM_ID, S.CLAIM_DESC, S.RUN_ID)
  FROM 
 GCT20F096T S 
SOURCE QUALIFIERSQ_TGT_JNR_TRANSONE2
INSERT INTO 
 TGT_JNR_TRANSONE
 (CUSTOMER_ID,IPS_CUSTOMER_ID_NUM,INDUSTRY_ID,CLAIM_ID,CLAIM_DESC,LOB_ID,COUNTRY_ID,TYPE_OF_EVENT_ID1,TYPE_OF_VEHICLE1,TYPE_OF_COVERAGE1,CLAIM_STATUS_ID1,CONTRACT_ID1,PROGRAM_ID1,YEAR_ID1,INSURED_F1,TOTAL_VEHICLES_F_OD1,TOTAL_VEHICLES_F_TPL1,RUN_ID1,CUSTOMER_ID3,IPS_CUSTOMER_ID_NUM3,INDUSTRY_ID3,CLAIM_ID3,CLAIM_DESC3,LOB_ID3,COUNTRY_ID3,TYPE_OF_EVENT_ID3,TYPE_OF_VEHICLE3,TYPE_OF_COVERAGE3,CLAIM_STATUS_ID3,CONTRACT_ID3,PROGRAM_ID3,YEAR_ID3,INSURED_F3,TOTAL_VEHICLES_F_OD3,TOTAL_VEHICLES_F_TPL3,RUN_ID3)
  SELECT 
(S.CUSTOMER_ID1, S.IPS_CUSTOMER_ID_NUM1, S.INDUSTRY_ID1, S.CLAIM_ID1, S.CLAIM_DESC1, S.LOB_ID1, S.COUNTRY_ID1, S.TYPE_OF_EVENT_ID11, S.TYPE_OF_VEHICLE11, S.TYPE_OF_COVERAGE11, S.CLAIM_STATUS_ID11, S.CONTRACT_ID11, S.PROGRAM_ID11, S.YEAR_ID11, S.INSURED_F11, S.TOTAL_VEHICLES_F_OD11, S.TOTAL_VEHICLES_F_TPL11, S.RUN_ID11, S.CUSTOMER_ID31, S.IPS_CUSTOMER_ID_NUM31, S.INDUSTRY_ID31, S.CLAIM_ID31, S.CLAIM_DESC31, S.LOB_ID31, S.COUNTRY_ID31, S.TYPE_OF_EVENT_ID31, S.TYPE_OF_VEHICLE31, S.TYPE_OF_COVERAGE31, S.CLAIM_STATUS_ID31, S.CONTRACT_ID31, S.PROGRAM_ID31, S.YEAR_ID31, S.INSURED_F31, S.TOTAL_VEHICLES_F_OD31, S.TOTAL_VEHICLES_F_TPL31, S.RUN_ID31)
  FROM 
 TGT_JNR_TRANSONE2 S 
EXPRESSION EXP_TESTTHREE
EXPRESSION EXP_TESTTHREE
FILTER FIL_TGT_EXP_TESTTHREE
INSERT INTO 
 TGT_EXP_TESTTHREE
 (CUSTOMER_ID,IPS_CUSTOMER_ID_NUM,INDUSTRY_ID,CLAIM_ID,CLAIM_DESC,LOB_ID,COUNTRY_ID)
  SELECT 
 (S.CUSTOMER_ID1, S.IPS_CUSTOMER_ID_NUM1, S.INDUSTRY_ID1, S.CLAIM_ID1, S.CLAIM_DESC1, S.LOB_ID1, S.COUNTRY_ID1)
  FROM TGT_RTR_TESTONE S 
  WHERE 
 TRUE
 
FILTER FIL_EXP_TESTTWO
INSERT INTO 
 TGT_EXP_TESTTHREE
 (CUSTOMER_ID,IPS_CUSTOMER_ID_NUM,INDUSTRY_ID,CLAIM_ID,CLAIM_DESC,LOB_ID,COUNTRY_ID)
  SELECT 
 (S.CUSTOMER_ID1, S.IPS_CUSTOMER_ID_NUM1, S.INDUSTRY_ID1, S.CLAIM_ID1, S.CLAIM_DESC1, S.LOB_ID1, S.COUNTRY_ID1)
  FROM TGT_RTR_TESTONE S 
  WHERE 
 TRUE
 
SOURCE QUALIFIERSQ_GCT20F095T
INSERT INTO 
 TGT_RTR_TESTONE
 (CUSTOMER_ID,IPS_CUSTOMER_ID_NUM,INDUSTRY_ID,CLAIM_ID,CLAIM_DESC,LOB_ID,COUNTRY_ID,TYPE_OF_EVENT_ID,TYPE_OF_VEHICLE,TYPE_OF_COVERAGE,CLAIM_STATUS_ID,CONTRACT_ID,PROGRAM_ID,YEAR_ID,INSURED_F,TOTAL_VEHICLES_F_OD,TOTAL_VEHICLES_F_TPL,RUN_ID)
  SELECT 
(S.CUSTOMER_ID, S.IPS_CUSTOMER_ID_NUM, S.INDUSTRY_ID, S.CLAIM_ID, S.CLAIM_DESC, S.LOB_ID, S.COUNTRY_ID, S.TYPE_OF_EVENT_ID, S.TYPE_OF_VEHICLE, S.TYPE_OF_COVERAGE, S.CLAIM_STATUS_ID, S.CONTRACT_ID, S.PROGRAM_ID, S.YEAR_ID, S.INSURED_F, S.TOTAL_VEHICLES_F_OD, S.TOTAL_VEHICLES_F_TPL, S.RUN_ID)
  FROM 
 GCT20F095T S 
EXPRESSION EXP_TESTTWO
EXPRESSION EXP_TESTTWO
FILTER FIL_TGT_EXP_TESTTWO
INSERT INTO 
 TGT_EXP_TESTTWO
 (TYPE_OF_EVENT_ID1,TYPE_OF_VEHICLE1,TYPE_OF_COVERAGE1,CLAIM_STATUS_ID1,CONTRACT_ID1,PROGRAM_ID1,YEAR_ID1,INSURED_F1,TOTAL_VEHICLES_F_OD1,TOTAL_VEHICLES_F_TPL1,RUN_ID1)
  SELECT 
 (S.TYPE_OF_EVENT_ID1, S.TYPE_OF_VEHICLE1, S.TYPE_OF_COVERAGE1, S.CLAIM_STATUS_ID1, S.CONTRACT_ID1, S.PROGRAM_ID1, S.YEAR_ID1, S.INSURED_F1, S.TOTAL_VEHICLES_F_OD1, S.TOTAL_VEHICLES_F_TPL1, S.RUN_ID1)
  FROM TGT_RTR_TESTONE S 
  WHERE 
 TRUE
 
SOURCE QUALIFIERSQ_TGT_JNR_TRANSONE3
INSERT INTO 
 TGT_JNR_TRANSONE
 (CUSTOMER_ID,IPS_CUSTOMER_ID_NUM,INDUSTRY_ID,CLAIM_ID,CLAIM_DESC,LOB_ID,COUNTRY_ID,TYPE_OF_EVENT_ID1,TYPE_OF_VEHICLE1,TYPE_OF_COVERAGE1,CLAIM_STATUS_ID1,CONTRACT_ID1,PROGRAM_ID1,YEAR_ID1,INSURED_F1,TOTAL_VEHICLES_F_OD1,TOTAL_VEHICLES_F_TPL1,RUN_ID1,CUSTOMER_ID3,IPS_CUSTOMER_ID_NUM3,INDUSTRY_ID3,CLAIM_ID3,CLAIM_DESC3,LOB_ID3,COUNTRY_ID3,TYPE_OF_EVENT_ID3,TYPE_OF_VEHICLE3,TYPE_OF_COVERAGE3,CLAIM_STATUS_ID3,CONTRACT_ID3,PROGRAM_ID3,YEAR_ID3,INSURED_F3,TOTAL_VEHICLES_F_OD3,TOTAL_VEHICLES_F_TPL3,RUN_ID3)
  SELECT 
(S.CUSTOMER_ID2, S.IPS_CUSTOMER_ID_NUM2, S.INDUSTRY_ID2, S.CLAIM_ID2, S.CLAIM_DESC2, S.LOB_ID2, S.COUNTRY_ID2, S.TYPE_OF_EVENT_ID12, S.TYPE_OF_VEHICLE12, S.TYPE_OF_COVERAGE12, S.CLAIM_STATUS_ID12, S.CONTRACT_ID12, S.PROGRAM_ID12, S.YEAR_ID12, S.INSURED_F12, S.TOTAL_VEHICLES_F_OD12, S.TOTAL_VEHICLES_F_TPL12, S.RUN_ID12, S.CUSTOMER_ID32, S.IPS_CUSTOMER_ID_NUM32, S.INDUSTRY_ID32, S.CLAIM_ID32, S.CLAIM_DESC32, S.LOB_ID32, S.COUNTRY_ID32, S.TYPE_OF_EVENT_ID32, S.TYPE_OF_VEHICLE32, S.TYPE_OF_COVERAGE32, S.CLAIM_STATUS_ID32, S.CONTRACT_ID32, S.PROGRAM_ID32, S.YEAR_ID32, S.INSURED_F32, S.TOTAL_VEHICLES_F_OD32, S.TOTAL_VEHICLES_F_TPL32, S.RUN_ID32)
  FROM 
 TGT_JNR_TRANSONE3 S 
EXPRESSION EXP_TESTONE
EXPRESSION EXP_TESTONE
FILTER FIL_TGT_EXP_TESTONE
INSERT INTO 
 TGT_EXP_TESTONE
 (CUSTOMER_ID3,IPS_CUSTOMER_ID_NUM3,INDUSTRY_ID3,CLAIM_ID3,CLAIM_DESC3,LOB_ID3,COUNTRY_ID3,TYPE_OF_EVENT_ID3,TYPE_OF_VEHICLE3,TYPE_OF_COVERAGE3,CLAIM_STATUS_ID3,CONTRACT_ID3,PROGRAM_ID3,YEAR_ID3,INSURED_F3,TOTAL_VEHICLES_F_OD3,TOTAL_VEHICLES_F_TPL3,RUN_ID3)
  SELECT 
 (S.CUSTOMER_ID3, S.IPS_CUSTOMER_ID_NUM3, S.INDUSTRY_ID3, S.CLAIM_ID3, S.CLAIM_DESC3, S.LOB_ID3, S.COUNTRY_ID3, S.TYPE_OF_EVENT_ID3, S.TYPE_OF_VEHICLE3, S.TYPE_OF_COVERAGE3, S.CLAIM_STATUS_ID3, S.CONTRACT_ID3, S.PROGRAM_ID3, S.YEAR_ID3, S.INSURED_F3, S.TOTAL_VEHICLES_F_OD3, S.TOTAL_VEHICLES_F_TPL3, S.RUN_ID3)
  FROM TGT_RTR_TESTONE S 
  WHERE 
 TRUE
 
