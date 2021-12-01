package services;

import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;


import java.util.List;
import java.util.Map;

public class DBServices {

    public StringBuilder runParametricDBQuery(List<Map<String, String>> queryData){
        StringBuilder results = null;
        try {
            results = runParametricQuery(queryData);
            
        } catch (Throwable e) {
            System.out.println("Exception while running the parametric query");
        }
        return results;

    }

    public StringBuilder runParametricQuery(List<Map<String, String>> queryData) {
        StringBuilder selectStr = new StringBuilder("SELECT ");
        StringBuilder fromStr = new StringBuilder(" FROM ");
        StringBuilder whereStr = new StringBuilder(" WHERE 1=1 ");
        StringBuilder groupByStr = new StringBuilder(" GROUP BY ");
        StringBuilder orderByStr = new StringBuilder(" ORDER BY ");
        StringBuilder query = new StringBuilder("");

        for (Map<String, String> queryDataItem : queryData) {
            if (!queryDataItem.containsKey("OPERATOR") || !queryDataItem.containsKey("OPERAND"))
                System.out.println("'OPERATOR' or 'OPERAND' not specified for the query!");

            switch (queryDataItem.get("OPERATOR").toUpperCase().trim()) {
                case "SELECT":
                    selectStr.append(queryDataItem.get("OPERAND")).append(",");
                    break;
                case "FROM" :
                    fromStr.append(queryDataItem.get("OPERAND"));
                    break;
                case "WHERE":
                case "AND":
                    whereStr.append(" AND ").append(queryDataItem.get("OPERAND"));
                    break;
                case "OR":
                    whereStr.append(" OR ").append(queryDataItem.get("OPERAND"));
                    break;
                case "ORDER BY":
                    orderByStr.append(queryDataItem.get("OPERAND")).append(",");
                    break;
                case "GROUP BY":
                    groupByStr.append(queryDataItem.get("OPERAND")).append(",");
                    break;
                default:
                    System.out.println(String.format("OPERATOR: %s Not supported from database query!", queryDataItem.get("OPERATOR")));
            }
        }
        selectStr.deleteCharAt(selectStr.length()-1);
        orderByStr.deleteCharAt(orderByStr.length()-1);
        groupByStr.deleteCharAt(groupByStr.length()-1);

        query = selectStr.append(fromStr);
        if (!whereStr.toString().trim().equals("WHERE 1=1"))
            query.append(whereStr);
        if (!orderByStr.toString().trim().equals("ORDER BY"))
            query.append(orderByStr);
        if (!groupByStr.toString().trim().equals("GROUP BY"))
            query.append(groupByStr);

        ResultSetHandler<List<Map<String, Object>>> resultSetHandler = new MapListHandler();
        return query;
    }


}
