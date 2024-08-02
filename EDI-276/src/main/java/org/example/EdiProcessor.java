//package org.example;
//
//import com.fasterxml.jackson.databind.JsonNode;
//import com.fasterxml.jackson.databind.ObjectMapper;
//
//import java.io.IOException;
//import java.util.Iterator;
//import java.util.Map;
//
//public class EdiProcessor {
//    public static void main(String[] args) {
////        String jsonInput = "{\n" +
////                "    \"SegmentDelimiter\": \"~\",\n" +
////                "    \"DataElementDelimiter\": \"*\",\n" +
////                "    \"ISA\": {\n" +
////                "        \"ISA01\": \"00\",\n" +
////                "        \"ISA02\": \"         \",\n" +
////                "        \"ISA03\": \"00\",\n" +
////                "        \"ISA04\": \"          \",\n" +
////                "        \"ISA05\": \"ZZ\",\n" +
////                "        \"ISA06\": \"9012345720000  \",\n" +
////                "        \"ISA07\": \"ZZ\",\n" +
////                "        \"ISA08\": \"9088877320000  \",\n" +
////                "        \"ISA09\": \"161026\",\n" +
////                "        \"ISA10\": \"0817\",\n" +
////                "        \"ISA11\": \"+\",\n" +
////                "        \"ISA12\": \"00501\",\n" +
////                "        \"ISA13\": \"000001523\",\n" +
////                "        \"ISA14\": \"0\",\n" +
////                "        \"ISA15\": \"T\",\n" +
////                "        \"ISA16\": \":\"\n" +
////                "    },\n" +
////                "    \"GS\": {\n" +
////                "        \"GS01\": \"HI\",\n" +
////                "        \"GS02\": \"9012345720000\",\n" +
////                "        \"GS03\": \"9088877320000\",\n" +
////                "        \"GS04\": \"20180125\",\n" +
////                "        \"GS05\": \"1700\",\n" +
////                "        \"GS06\": \"1523\",\n" +
////                "        \"GS07\": \"X\",\n" +
////                "        \"GS08\": \"005010X217\"\n" +
////                "    },\n" +
////                "    \"ST\": {\n" +
////                "        \"ST01\": \"278\",\n" +
////                "        \"ST02\": \"1523\",\n" +
////                "        \"ST03\": \"005010X217\"\n" +
////                "    },\n" +
////                "    \"BHT\": {\n" +
////                "        \"BHT03\": \"4000000000001\",\n" + // Required when the transaction is used in real-time
////                "        \"BHT05\": \"1700\",\n" +  // Transaction Set Creation Time
////                "    },\n" +
////                "    \"LOOP2100A\": {\n" +
////                "        \"NM1\": {\n" +
////                "            \"NM103\": \"GEORGIA HEALTH\",\n" +
////                "            \"NM108\": \"PI\",\n" +
////                "            \"NM109\": \"77034\"\n" +
////                "        }\n" +
////                "    },\n" +
////                "    \"LOOP2100C\": {\n" +
////                "        \"NM1\": {\n" +
////                "            \"NM108\": \"SV\",\n" +
////                "            \"NM109\": \"X67E\"\n" +
////                "        }\n" +
////                "    },\n" +
////                "    \"LOOP2000D\": {\n" +
////                "        \"HL\": {\n" +
////                "            \"HL01\": \"1\",\n" +
////                "            \"HL03\": \"20\",\n" +
////                "            \"HL04\": \"1\"\n" +
////                "        }\n" +
////                "    },\n" +
////                "    \"LOOP2100D\": [\n" +
////                "        {\n" +
////                "            \"NM1\": {\n" +
////                "                \"NM101\": \"\",\n" +
////                "                \"NM102\": \"1\",\n" +
////                "                \"NM103\": \"KEITH\",\n" +
////                "                \"NM104\": \"CHRIS\",\n" +
////                "                \"NM108\": \"MI\",\n" +
////                "                \"NM109\": \"123456789012\"\n" +
////                "            }\n" +
////                "        },\n" +
////                "        {\n" +
////                "            \"NM1\": {\n" +
////                "                \"NM101\": \"IL\",\n" +
////                "                \"NM102\": \"1\",\n" +
////                "                \"NM103\": \"Williams\",\n" +
////                "                \"NM104\": \"Chris\",\n" +
////                "                \"NM108\": \"MI\",\n" +
////                "                \"NM109\": \"123456789012\"\n" +
////                "            },\n" +
////                "            \"LOOP2200D\": [\n" +
////                "                {\n" +
////                "                    \"TRN\": {\n" +
////                "                        \"TRN01\": \"1\",\n" +
////                "                        \"TRN02\": \"1234567890\",\n" +
////                "                        \"TRN03\": \"9876543210\"\n" +
////                "                    }\n" +
////                "                },\n" +
////                "                {\n" +
////                "                    \"REF\": [\n" +
////                "                        {\n" +
////                "                            \"REF01\": \"1K\",\n" +
////                "                            \"REF02\": \"2013090000001\"\n" +
////                "                        },\n" +
////                "                        {\n" +
////                "                            \"REF01\": \"D9\",\n" +
////                "                            \"REF02\": \"CHTRACENUM\"\n" +
////                "                        },\n" +
////                "                        {\n" +
////                "                            \"REF01\": \"EJ\",\n" +
////                "                            \"REF02\": \"REFERENCEE\"\n" +
////                "                        }\n" +
////                "                    ]\n" +
////                "                },\n" +
////                "                {\n" +
////                "                    \"AMT\": [\n" +
////                "                        {\n" +
////                "                            \"AMT01\": \"T3\"\n" +
////                "                        }\n" +
////                "                    ]\n" +
////                "                },\n" +
////                "                {\n" +
////                "                    \"DTP\": [\n" +
////                "                        {\n" +
////                "                            \"DTP01\": \"472\",\n" +
////                "                            \"DTP02\": \"RD8\",\n" +
////                "                            \"DTP03\": \"20230101-20230131\"\n" +
////                "                        }\n" +
////                "                    ]\n" +
////                "                },\n" +
////                "                {\n" +
////                "                    \"LOOP2210D\": {\n" +
////                "                        \"SVC\": {\n" +
////                "                            \"SVC01-1\": \"HC\",\n" +
////                "                            \"SVC01-2\": \"H2017\",\n" +
////                "                            \"SVC02\": \"U4:U6\",\n" +
////                "                            \"SVC03\": \"150\",\n" +
////                "                            \"SVC04\": \"1\"\n" +
////                "                        },\n" +
////                "                        \"DTP\": {\n" +
////                "                            \"DTP01\": \"472\",\n" +
////                "                            \"DTP02\": \"RD8\",\n" +
////                "                            \"DTP03\": \"20230101-20230131\"\n" +
////                "                        },\n" +
////                "                        \"AMT\": {\n" +
////                "                            \"AMT01\": \"T3\",\n" +
////                "                            \"AMT02\": \"150.00\"\n" +
////                "                        }\n" +
////                "                    }\n" +
////                "                }\n" +
////                "            ]\n" +
////                "        }\n" +
////                "    ],\n" +
////                "    \"IEA\": {\n" +
////                "        \"IEA01\": \"1\",\n" +
////                "        \"IEA02\": \"000001523\"\n" +
////                "    },\n" +
////                "    \"GE\": {\n" +
////                "        \"GE01\": \"1\",\n" +
////                "        \"GE02\": \"1523\"\n" +
////                "    },\n" +
////                "    \"SE\": {\n" +
////                "        \"SE01\": \"10\",\n" +
////                "        \"SE02\": \"1523\"\n" +
////                "    }\n" +
////                "}";
//        String jsonInput = "{\n" +
//                "    \"SegmentDelimiter\": \"~\",\n" +
//                "    \"DataElementDelimiter\": \"*\",\n" +
//                "    \"ISA\": {\n" +
//                "        \"ISA01\": \"00\",\n" +
//                "        \"ISA02\": \"          \",\n" +
//                "        \"ISA03\": \"00\",\n" +
//                "        \"ISA04\": \"          \",\n" +
//                "        \"ISA05\": \"ZZ\",\n" +
//                "        \"ISA06\": \"Trading PartnerID\",\n" +
//                "        \"ISA07\": \"ZZ\",\n" +
//                "        \"ISA08\": \"Trading PartnerID\",\n" +
//                "        \"ISA09\": \"240706\",\n" +
//                "        \"ISA10\": \"1030\",\n" +
//                "        \"ISA11\": \"^\",\n" +
//                "        \"ISA12\": \"00501\",\n" +
//                "        \"ISA13\": \"000000001\",\n" +
//                "        \"ISA14\": \"0\",\n" +
//                "        \"ISA15\": \"T\",\n" +
//                "        \"ISA16\": \":\"\n" +
//                "    },\n" +
//                "    \"IEA\": {\n" +
//                "        \"IEA01\": \"1\",\n" +
//                "        \"IEA02\": \"000000001\"\n" +
//                "    },\n" +
//                "    \"GS\": {\n" +
//                "        \"GS01\": \"HR\",\n" +
//                "        \"GS02\": \"Trading PartnerID\",\n" +
//                "        \"GS03\": \"Trading PartnerID\",\n" +
//                "        \"GS04\": \"20240706\",\n" +
//                "        \"GS05\": \"1030\",\n" +
//                "        \"GS06\": \"1\",\n" +
//                "        \"GS07\": \"X\",\n" +
//                "        \"GS08\": \"005010X212\"\n" +
//                "    },\n" +
//                "    \"ST\": {\n" +
//                "        \"ST01\": \"276\",\n" +
//                "        \"ST02\": \"0001\",\n" +
//                "        \"ST03\": \"005010X212\"\n" +
//                "    },\n" +
//                "    \"BHT\": {\n" +
//                "        \"BHT03\": \"1234567890\",\n" +
//                "        \"BHT05\": \"0830\"\n" +
//                "    },\n" +
//                "    \"LOOP2100A\": {\n" +
//                "        \"NM1\": {\n" +
//                "            \"NM103\": \"GEORGIA HEALTH PARTNERSHIP\",\n" +
//                "            \"NM108\": \"PI\",\n" +
//                "            \"NM109\": \"77034\"\n" +
//                "        }\n" +
//                "    },\n" +
//                "    \"LOOP2100B\": {\n" +
//                "        \"NM1\": {\n" +
//                "            \"NM103\": \"Information Receiver Name\",\n" +
//                "            \"NM109\": \"ReceiverID\"\n" +
//                "        }\n" +
//                "    },\n" +
//                "    \"LOOP2100C\": {\n" +
//                "        \"NM1\": {\n" +
//                "            \"NM108\": \"SV\",\n" +
//                "            \"NM109\": \"1234567890\"\n" +
//                "        }\n" +
//                "    },\n" +
//                "    \"LOOP2000D\": {\n" +
//                "        \"HL\": {\n" +
//                "            \"HL01\": \"1\",\n" +
//                "            \"HL03\": \"20\",\n" +
//                "            \"HL04\": \"1\"\n" +
//                "        }\n" +
//                "    },\n" +
//                "    \"LOOP2100D\": [\n" +
//                "        {\n" +
//                "            \"NM1\": {\n" +
//                "                \"NM102\": \"1\",\n" +
//                "                \"NM103\": \"DOE\",\n" +
//                "                \"NM104\": \"JOHN\",\n" +
//                "                \"NM108\": \"MI\",\n" +
//                "                \"NM109\": \"123456789012\"\n" +
//                "            },\n" +
//                "            \"LOOP2200D\": [\n" +
//                "                {\n" +
//                "                    \"TRN\": {\n" +
//                "                        \"TRN01\": \"1\",\n" +
//                "                        \"TRN02\": \"1234567890\",\n" +
//                "                        \"TRN03\": \"9876543210\"\n" +
//                "                    }\n" +
//                "                },\n" +
//                "                {\n" +
//                "                    \"REF\": [\n" +
//                "                        {\n" +
//                "                            \"REF01\": \"1K\",\n" +
//                "                            \"REF02\": \"1234567890123\"\n" +
//                "                        },\n" +
//                "                        {\n" +
//                "                            \"REF01\": \"D9\",\n" +
//                "                            \"REF02\": \"CHTRACENUM\"\n" +
//                "                        },\n" +
//                "                        {\n" +
//                "                            \"REF01\": \"EJ\",\n" +
//                "                            \"REF02\": \"REFERENCEE\"\n" +
//                "                        }\n" +
//                "                    ]\n" +
//                "                },\n" +
//                "                {\n" +
//                "                    \"AMT\": [\n" +
//                "                        {\n" +
//                "                            \"AMT01\": \"T3\",\n" +
//                "                            \"AMT02\": \"123456.78\"\n" +
//                "                        }\n" +
//                "                    ]\n" +
//                "                },\n" +
//                "                {\n" +
//                "                    \"DTP\": [\n" +
//                "                        {\n" +
//                "                            \"DTP01\": \"472\",\n" +
//                "                            \"DTP02\": \"RD8\",\n" +
//                "                            \"DTP03\": \"20230701-20230710\"\n" +
//                "                        }\n" +
//                "                    ]\n" +
//                "                },\n" +
//                "                {\n" +
//                "                    \"LOOP2210D\": {\n" +
//                "                        \"SVC\": {\n" +
//                "                            \"SVC01-1\": \"HC\",\n" +
//                "                            \"SVC01-2\": \"J3490\",\n" +
//                "                            \"SVC02\": \"150.00\",\n" +
//                "                            \"SVC03\": \"120.00\"\n" +
//                "                        },\n" +
//                "                        \"DTP\": {\n" +
//                "                            \"DTP01\": \"472\",\n" +
//                "                            \"DTP02\": \"RD8\",\n" +
//                "                            \"DTP03\": \"20230701-20230710\"\n" +
//                "                        }\n" +
//                "                    }\n" +
//                "                }\n" +
//                "            ]\n" +
//                "        }\n" +
//                "    ],\n" +
//                "    \"GE\": {\n" +
//                "        \"GE01\": \"1\",\n" +
//                "        \"GE02\": \"1\"\n" +
//                "    },\n" +
//                "    \"SE\": {\n" +
//                "        \"SE01\": \"23\",\n" +
//                "        \"SE02\": \"0001\"\n" +
//                "    }\n" +
//                "}";
//
//
//        try {
//            jsonToEdiModel(jsonInput);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    private static void jsonToEdiModel(String json) throws IOException {
//        ObjectMapper objectMapper = new ObjectMapper();
//        JsonNode parentNode = objectMapper.readTree(json);
//
//        // Process ISA Segment
//        JsonNode isaNode = parentNode.path("ISA");
//        if (!isaNode.isMissingNode()) {
//            processSegment("ISA", isaNode, parentNode);
//        }
//
//        // Process GS Segment
//        JsonNode gsNode = parentNode.path("GS");
//        if (!gsNode.isMissingNode()) {
//            processSegment("GS", gsNode, parentNode);
//        }
//
//        // Process ST Segment
//        JsonNode stNode = parentNode.path("ST");
//        if (!stNode.isMissingNode()) {
//            processSegment("ST", stNode, parentNode);
//        }
//
//        // Process BHT Segment
//        JsonNode bhtNode = parentNode.path("BHT");
//        if (!bhtNode.isMissingNode()) {
//            processSegment("BHT", bhtNode, parentNode);
//        }
//
//        // Process LOOP2100A Segment
//        JsonNode loop2100ANode = parentNode.path("LOOP2100A");
//        if (!loop2100ANode.isMissingNode()) {
//            JsonNode nm1Node = loop2100ANode.path("NM1");
//            if (!nm1Node.isMissingNode()) {
//                processSegment("NM1", nm1Node, parentNode);
//            }
//        }
//
//        // Process LOOP2100C Segment
//        JsonNode loop2100CNode = parentNode.path("LOOP2100C");
//        if (!loop2100CNode.isMissingNode()) {
//            JsonNode nm1Node = loop2100CNode.path("NM1");
//            if (!nm1Node.isMissingNode()) {
//                processSegment("NM1", nm1Node, parentNode);
//            }
//        }
//
//        // Process LOOP2000D Segment
//        JsonNode loop2000DNode = parentNode.path("LOOP2000D");
//        if (!loop2000DNode.isMissingNode()) {
//            JsonNode hlNode = loop2000DNode.path("HL");
//            if (!hlNode.isMissingNode()) {
//                processSegment("HL", hlNode, parentNode);
//            }
//        }
//
//        // Process LOOP2100D Segment
//        JsonNode loop2100DNode = parentNode.path("LOOP2100D");
//        if (loop2100DNode.isArray()) {
//            for (JsonNode item : loop2100DNode) {
//                processSegment("NM1", item.path("NM1"), parentNode);
//                processSegment("TRN", item.path("TRN"), parentNode);
//                processArraySegment("REF", item.path("REF"), parentNode);
//                processArraySegment("DTP", item.path("DTP"), parentNode);
//
//                JsonNode loop2200DNode = item.path("LOOP2200D");
//                if (loop2200DNode.isArray()) {
//                    for (JsonNode loop2200DItem : loop2200DNode) {
//                        processSegment("TRN", loop2200DItem.path("TRN"), parentNode);
//                        processArraySegment("REF", loop2200DItem.path("REF"), parentNode);
//                        processArraySegment("AMT", loop2200DItem.path("AMT"), parentNode);
//                        processArraySegment("DTP", loop2200DItem.path("DTP"), parentNode);
//
//                        JsonNode loop2210DNode = loop2200DItem.path("LOOP2210D");
//                        processSegment("SVC", loop2210DNode.path("SVC"), parentNode);
//                        processSegment("DTP", loop2210DNode.path("DTP"), parentNode);
//                        processSegment("AMT", loop2210DNode.path("AMT"), parentNode);
//                    }
//                }
//            }
//        }
//
//
//        // Process SE Segment
//        JsonNode seNode = parentNode.path("SE");
//        if (!seNode.isMissingNode()) {
//            processSegment("SE", seNode, parentNode);
//        }
//
//        // Process GE Segment
//        JsonNode geNode = parentNode.path("GE");
//        if (!geNode.isMissingNode()) {
//            processSegment("GE", geNode, parentNode);
//        }
//
//        // Process IEA Segment
//        JsonNode ieaNode = parentNode.path("IEA");
//        if (!ieaNode.isMissingNode()) {
//            processSegment("IEA", ieaNode, parentNode);
//        }
//    }
//
//    private static void processEdiSegment(String isa, JsonNode isaNode, JsonNode parentNode) {
//    }
//
//    private static void processSegment(String segmentName, JsonNode segmentNode, JsonNode parentNode) {
//        if (segmentNode.isMissingNode()) {
//            return;
//        }
//
//
//        String elementDelimiter = parentNode.path("DataElementDelimiter").asText();
//        String segmentDelimiter = parentNode.path("SegmentDelimiter").asText();
//
//        StringBuilder segmentBuilder = new StringBuilder(segmentName);
//
//        Iterator<Map.Entry<String, JsonNode>> fields = segmentNode.fields();
//        while (fields.hasNext()) {
//            Map.Entry<String, JsonNode> field = fields.next();
//            String fieldValue = field.getValue().asText("").trim();
//            segmentBuilder.append(elementDelimiter).append(fieldValue);
//        }
//
//        segmentBuilder.append(segmentDelimiter);
//        System.out.println(segmentBuilder.toString());
//    }
//
//    private static void processArraySegment(String segmentName, JsonNode arrayNode, JsonNode parentNode) {
//        if (arrayNode.isArray()) {
//            for (JsonNode item : arrayNode) {
//                processSegment(segmentName, item, parentNode);
//            }
//        } else {
//            processSegment(segmentName, arrayNode, parentNode);
//        }
//    }
//
//    private static void processLoop(String segmentName, JsonNode loopNode, JsonNode parentNode) {
//        if (!loopNode.isMissingNode()) {
//            processSegment(segmentName, loopNode, parentNode);
//        }
//    }
//}