package com.canal;

import com.alibaba.otter.canal.client.CanalConnector;
import com.alibaba.otter.canal.client.CanalConnectors;
import com.alibaba.otter.canal.protocol.CanalEntry;
import com.alibaba.otter.canal.protocol.Message;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.net.InetSocketAddress;
import java.util.List;

public class CanalClient {

    private static String server_address="192.168.88.130";
    private static int port=11111;
    private static String destination="example";
    private static String username="";
    private static String password="";

    public static void main(String[] args) {
        CanalConnector canalConnector = CanalConnectors.newSingleConnector(new InetSocketAddress(server_address, port), destination, username, password);
        canalConnector.connect();
        canalConnector.subscribe(".*\\..*");
        canalConnector.rollback();
        while (true){
            Message message = canalConnector.getWithoutAck(100);
            long batchId=message.getId();
            if(batchId!=-1){
                System.out.println("batchId="+batchId);
                print(message.getEntries());
            }
        }
    }

    private static void print(List<CanalEntry.Entry> entries){
        for(CanalEntry.Entry entry:entries){
            if(entry.getEntryType()!=CanalEntry.EntryType.ROWDATA){
                continue;
            }
            try {
                CanalEntry.RowChange rowChange=CanalEntry.RowChange.parseFrom(entry.getStoreValue());
                for(CanalEntry.RowData rowData:rowChange.getRowDatasList()){
                    switch (rowChange.getEventType()){
                        case INSERT:
                            String tableName = entry.getHeader().getTableName();
                            System.out.println("insert===========");
                            System.out.println("after="+getColumns(rowData.getAfterColumnsList()));
                            System.out.println("before="+getColumns(rowData.getBeforeColumnsList()));
                            break;
                        case DELETE:
                            System.out.println("delete===========");
                            System.out.println("after="+getColumns(rowData.getAfterColumnsList()));
                            System.out.println("before="+getColumns(rowData.getBeforeColumnsList()));
                            break;
                        case UPDATE:
                            System.out.println("update===========");
                            System.out.println("after="+getColumns(rowData.getAfterColumnsList()));
                            System.out.println("before="+getColumns(rowData.getBeforeColumnsList()));
                            break;
                        default:
                            break;
                    }
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    private static String getColumns(List<CanalEntry.Column> columns){
        JsonObject gson = new JsonObject();
        for(CanalEntry.Column column:columns){
            gson.addProperty(column.getName(),column.getValue());
        }
        return gson.toString();
    }
}
