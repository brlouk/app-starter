 select
        * 
    from
        ( select
            row_.*,
            rownum rownum_ 
        from
            ( select
                trace0_.REPLAY_INDEX as REPLAY_I1_0_,
                trace0_.status as status2_0_,
                trace0_.TECHNICAL_ID as TECHNICA3_0_,
                trace0_.activity as activity4_0_,
                trace0_."ARCHIVE" as ARCHIVE5_0_,
                trace0_.BUSINESS_DATA as BUSINESS6_0_,
                trace0_.CANCEL_FLAG as CANCEL_F7_0_,
                trace0_.COUNTRY_CODE as COUNTRY_8_0_,
                trace0_.ERROR_CODE as ERROR_CO9_0_,
                trace0_.ERROR_MESSAGE as ERROR_M10_0_,
                trace0_.kpi as kpi11_0_,
                trace0_.KPI_VALUE as KPI_VAL12_0_,
                trace0_.PARENT_TECHNICAL_ID as PARENT_13_0_,
                trace0_.process as process14_0_,
                trace0_.PROCESS_INSTANCE as PROCESS15_0_,
                trace0_.PROCESS_VERSION as PROCESS16_0_,
                trace0_.REPLAY_LOCK as REPLAY_17_0_,
                trace0_.SOURCE_APPLICATION_NAME as SOURCE_18_0_,
                trace0_.SOURCE_APPLICATION_USER as SOURCE_19_0_,
                trace0_.SOURCE_APPLICATION_VERSION as SOURCE_20_0_,
                trace0_.SUB_PROCESS as SUB_PRO21_0_,
                trace0_.SUB_PROCESS_INSTANCE as SUB_PRO22_0_,
                trace0_.TARGET_APPLICATION_NAME as TARGET_23_0_,
                trace0_.TARGET_APPLICATION_VERSION as TARGET_24_0_,
                trace0_."TIMESTAMP" as TIMESTA25_0_,
                trace0_.VALUE_DATE as VALUE_D26_0_ 
            from
                Trace trace0_ 
            where
                trace0_.REPLAY_INDEX is not null 
                or trace0_.status is not null 
                or trace0_.TECHNICAL_ID is not null 
            order by
                trace0_."TIMESTAMP" desc ) row_ ) 
        where
            rownum_ <= 5
            and rownum_ > 1