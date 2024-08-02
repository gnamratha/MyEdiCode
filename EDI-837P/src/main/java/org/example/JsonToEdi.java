package org.example;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class JsonToEdi {
    private static StringBuilder globalEdiBuilder = new StringBuilder();

    private static void appendToGlobalVariable(String output) {
        globalEdiBuilder.append(output).append("\n");
    }

    public static void main(String[] args) {
        String jsonString = "{"
                + "\"ISA\": {"
                + "    \"ISA01\": \"00\","
                + "    \"ISA02\": \"          \","
                + "    \"ISA03\": \"00\","
                + "    \"ISA04\": \"          \","
                + "    \"ISA05\": \"ZZ\","
                + "    \"ISA06\": \"300891\","
                + "    \"ISA07\": \"ZZ\","
                + "    \"ISA08\": \"77034\","
                + "    \"ISA09\": \"230115\","
                + "    \"ISA10\": \"1200\","
                + "    \"ISA11\": \"^\","
                + "    \"ISA12\": \"00501\","
                + "    \"ISA13\": \"000000001\","
                + "    \"ISA14\": \"0\","
                + "    \"ISA15\": \"T\","
                + "    \"ISA16\": \":\""
                + "},"
                + "\"GS\": {"
                + "    \"GS01\": \"HC\","
                + "    \"GS02\": \"300891\","
                + "    \"GS03\": \"77034\","
                + "    \"GS04\": \"20230115\","
                + "    \"GS05\": \"0815\","
                + "    \"GS06\": \"1\","
                + "    \"GS07\": \"X\","
                + "    \"GS08\": \"005010X222A1\""
                + "},"
                + "\"ST\": {"
                + "    \"ST01\": \"837\","
                + "    \"ST02\": \"000000001\","
                + "    \"ST03\": \"005010X222A1\""
                + "},"
                + "\"BHT\": {"
                + "    \"BHT01\": \"0019\","
                + "    \"BHT02\": \"00\","
                + "    \"BHT03\": \"2223254003792\","
                + "    \"BHT04\": \"20230118\","
                + "    \"BHT05\": \"1200\","
                + "    \"BHT06\": \"CH\""
                + "},"
                + "\"Loop1000A\": {"
                + "    \"NM1\": {"
                + "        \"NM101\": \"41\","
                + "        \"NM102\": \"2\","
                + "        \"NM103\": \"PREMIUM BILLING SERVICES\","
                + "        \"NM104\": \"JOHN\","
                + "        \"NM105\": \"\","
                + "        \"NM106\": \"\","
                + "        \"NM107\": \"\","
                + "        \"NM108\": \"\","
                + "        \"NM109\": \"300891\""
                + "    },"
                + "    \"PER\": {"
                + "        \"PER01\": \"IC\","
                + "        \"PER02\": \"JANE SMITH\","
                + "        \"PER03\": \"TE\","
                + "        \"PER04\": \"5559876543\""
                + "    }"
                + "},"
                + "\"Loop1000B\": {"
                + "    \"NM1\": {"
                + "        \"NM101\": \"\","
                + "        \"NM102\": \"\","
                + "        \"NM103\": \"GEORGIA HEALTH PARTNERSHIP\","
                + "        \"NM104\": \"\","
                + "        \"NM105\": \"\","
                + "        \"NM106\": \"\","
                + "        \"NM107\": \"\","
                + "        \"NM108\": \"\","
                + "        \"NM109\": \"77034\""
                + "    }"
                + "},"
                + "\"Loop2000A\": {"
                + "    \"HL\": {"
                + "        \"HL01\": \"1\","
                + "        \"HL02\": \"1\","
                + "        \"HL03\": \"21\""
                + "    },"
                + "    \"PRV\": {"
                + "        \"PRV01\": \"BI\","
                + "        \"PRV02\": \"PXC\","
                + "        \"PRV03\": \"251S00000X\""
                + "    }"
                + "},"
                + "\"Loop2010AA\": {"
                + "    \"NM1\": {"
                + "        \"NM101\": \"85\","
                + "        \"NM102\": \"2\","
                + "        \"NM103\": \"LGREEN20\","
                + "        \"NM104\": \"\","
                + "        \"NM105\": \"\","
                + "        \"NM106\": \"\","
                + "        \"NM107\": \"\","
                + "        \"NM108\": \"XX\","
                + "        \"NM109\": \"1881968584\""
                + "    },"
//                + "    \"N3\": {"
//                + "        \"N301\": \"234 SEAWAY ST\""
//                + "    },"
                + "    \"N4\": {"
                + "        \"N401\": \"STONE MOUNTAIN\","
                + "        \"N402\": \"FL\","
                + "        \"N403\": \"300833107\""
                + "    },"
                + "    \"REF\": {"
                + "        \"REF01\": \"EI\","
                + "        \"REF02\": \"587654321\""
                + "    }"
                + "},"
                + "\"Loop2000B\": {"
                + "    \"HL\": {"
                + "        \"HL01\": \"2\","
                + "        \"HL02\": \"1\","
                + "        \"HL03\": \"22\","
                + "        \"HL04\": \"1\""
                + "    },"
                + "    \"SBR\": {"
                + "        \"SBR01\": \"P\","
                + "        \"SBR02\": \"18\","
                + "        \"SBR03\": \"\","
                + "        \"SBR04\": \"\","
                + "        \"SBR05\": \"\","
                + "        \"SBR06\": \"\","
                + "        \"SBR07\": \"\","
                + "        \"SBR08\": \"\","
                + "        \"SBR09\": \"MC\""
                + "    }"
                + "},"
                + "\"Loop2010BA\": {"
                + "    \"NM1\": {"
                + "        \"NM101\": \"\","
                + "        \"NM102\": \"1\","
                + "        \"NM103\": \"FirstName\","
                + "        \"NM104\": \"\","
                + "        \"NM104\": \"\","
                + "        \"NM105\": \"\","
                + "        \"NM106\": \"\","
                + "        \"NM107\": \"\","
                + "        \"NM108\": \"MI\","
                + "        \"NM109\": \"987654321098\""
                + "    }"
//                + "    \"DMG\": {"
//                + "        \"DMG01\": \"D8\","
//                + "        \"DMG02\": \"19740112\","
//                + "        \"DMG03\": \"M\""
//                + "    }"
                + "},"
                + "\"Loop2010BB\": {"
                + "    \"NM1\": {"
                + "        \"NM101\": \"PR\","
                + "        \"NM102\": \"2\","
                + "        \"NM103\": \"GEORGIA HEALTH PARTNERSHIP\","
                + "        \"NM104\": \"\","
                + "        \"NM105\": \"\","
                + "        \"NM106\": \"\","
                + "        \"NM107\": \"\","
                + "        \"NM108\": \"\","
                + "        \"NM109\": \"77034\""
                + "    },"
                + "    \"N4\": {"
                + "        \"N401\": \"STONE MOUNTAIN\","
                + "        \"N402\": \"GA\","
                + "        \"N403\": \"300833107\""
                + "    },"
                + "    \"REF\": {"
                + "        \"REF01\": \"G2\","
                + "        \"REF02\": \"1234567890\""
                + "    }"
                + "},"
                + "\"Loop2300\": {"
                + "    \"CLM\": {"
                + "        \"CLM01\": \"1234567890\","
                + "        \"CLM02\": \"500\","
                + "        \"CLM05\": {"
                + "            \"CLM05-1\": \"31\","
                + "            \"CLM05-2\": \"B\","
                + "            \"CLM05-3\": \"1\""
                + "        },"
                + "        \"CLM09\": \"Y\","
                + "        \"CLM10\": \"A\","
                + "        \"CLM11\": \"Y\","
                + "        \"CLM12\": \"I\","
                + "        \"CLM11-1\": \"AA\","
                + "        \"CLM11-2\": \"AA\""
                + "    }"
                + "},"
//                + "    \"DTP\": ["
//                + "        {"
//                + "            \"DTP01\": \"96\","
//                + "            \"DTP02\": \"TM\","
//                + "            \"DTP03\": \"2060\""
//                + "        },"
//                + "        {"
//                + "            \"DTP01\": \"434\","
//                + "            \"DTP02\": \"RD8\","
//                + "            \"DTP03\": \"20230101-20230131\""
//                + "        }"
//                + "    ],"
//                + "    \"CL1\": {"
//                + "        \"CL101\": \"1\","
//                + "        \"CL102\": \"1\""
//                + "    },"
//                + "    \"CN1\": {"
//                + "        \"CN101\": \"D8\","
//                + "        \"CN102\": \"19740112\""
//                + "    },"
                + "    \"REF\": ["
                + "        {"
                + "            \"REF01\": \"F8\","
                + "            \"REF02\": \"1234567890123\""
                + "        },"
                + "        {"
                + "            \"REF01\": \"D9\","
                + "            \"REF02\": \"12345678901234567890\""
                + "        }"
                + "    ],"
                + "\"CRC\": {"
                + "    \"CRC01\": \"ZZ\","
                + "    \"CRC02\": \"Y\","
                + "    \"CRC03\": \"AV\""
                + "},"
                + "\"HI\": {"
                + "    \"HI01\": {"
                + "        \"HI01-1\": \"ABK\","
                + "        \"HI01-2\": \"V1981\""
                + "    },"
                + "    \"HI02\": {"
                + "        \"HI02-1\": \"ABF\","
                + "        \"HI02-2\": \"V1981\""
                + "    }"
                + "},"
                + "\"Loop2310A\": {"
                + "    \"NM1\": {"
                + "        \"NM101\": \"DN\","
                + "        \"NM102\": \"\","
                + "        \"NM103\": \"\","
                + "        \"NM104\": \"\","
                + "        \"NM105\": \"\","
                + "        \"NM106\": \"\","
                + "        \"NM107\": \"\","
                + "        \"NM108\": \"XX\","
                + "        \"NM109\": \"1881968584\""
                + "    },"
//                + "    \"N3\": {"
//                + "        \"N301\": \"234 DANTON ST\""
//                + "    },"
//                + "    \"N4\": {"
//                + "        \"N401\": \"ASHBURN\","
//                + "        \"N402\": \"VA\","
//                + "        \"N403\": \"20987\""
//                + "    },"
//                + "    \"PRV\": {"
//                + "        \"PRV01\": \"AT\","
//                + "        \"PRV02\": \"PXC\","
//                + "        \"PRV03\": \"453088947A\""
//                + "    },"
                + "    \"REF\": {"
                + "        \"REF01\": \"G2\","
                + "        \"REF02\": \"1234567890\""
                + "    }"
                + "},"
                + "\"Loop2310B\": {"
                + "    \"NM1\": {"
                + "        \"NM101\": \"\","
                + "        \"NM102\": \"\","
                + "        \"NM103\": \"\","
                + "        \"NM104\": \"\","
                + "        \"NM105\": \"\","
                + "        \"NM106\": \"\","
                + "        \"NM107\": \"\","
                + "        \"NM108\": \"XX\","
                + "        \"NM109\": \"1881968584\""
                + "    },"
                + "    \"REF\": {"
                + "        \"REF01\": \"LU\","
                + "        \"REF02\": \"1234567890\""
                + "    }"
                + "},"
//                + "\"Loop2310C\": {"
//                + "    \"NM1\": {"
//                + "        \"NM101\": \"ZZ\","
//                + "        \"NM108\": \"XX\","
//                + "        \"NM109\": \"9876577210\""
//                + "    }"
//                + "},"
//                + "\"Loop2310E\": {"
//                + "    \"NM1\": {"
//                + "        \"NM101\": \"77\","
//                + "        \"NM108\": \"XX\","
//                + "        \"NM109\": \"9876543260\""
//                + "    },"
//                + "    \"N3\": {"
//                + "        \"N301\": \"294 DANTON ST\""
//                + "    },"
//                + "    \"N4\": {"
//                + "        \"N401\": \"ASHBURN\","
//                + "        \"N402\": \"VA\","
//                + "        \"N403\": \"20987\""
//                + "    },"
//                + "    \"REF\": {"
//                + "        \"REF01\": \"G2\","
//                + "        \"REF02\": \"KA66633452\""
//                + "    }"
//                + "},"
//                + "\"Loop2310F\": {"
//                + "    \"NM1\": {"
//                + "        \"NM101\": \"DN\","
//                + "        \"NM108\": \"XX\","
//                + "        \"NM109\": \"7865334256\""
//                + "    },"
//                + "    \"N3\": {"
//                + "        \"N301\": \"123 DANTON ST\""
//                + "    },"
//                + "    \"N4\": {"
//                + "        \"N401\": \"ASHBURN\","
//                + "        \"N402\": \"VA\","
//                + "        \"N403\": \"20087\""
//                + "    },"
//                + "    \"REF\": {"
//                + "        \"REF01\": \"G2\","
//                + "        \"REF02\": \"KA66633452\""
//                + "    }"
//                + "},"
                + "\"Loop2320\": {"
                + "    \"SBR\": {"
                + "        \"SBR01\": \"P\","
                + "        \"SBR02\": \"18\","
                + "        \"SBR03\": \"\","
                + "        \"SBR04\": \"\","
                + "        \"SBR05\": \"\","
                + "        \"SBR06\": \"\","
                + "        \"SBR07\": \"\","
                + "        \"SBR08\": \"\","
                + "        \"SBR09\": \"MC\""
                + "    },"
                + "\"CAS\": {"
                + "        \"CAS02\": \"\","
                + "        \"CAS03\": \"\","
                + "        \"CAS05\": \"\","
                + "        \"CAS06\": \"\","
                + "        \"CAS08\": \"\","
                + "        \"CAS09\": \"\""
                + "    },"
                + "    \"AMT\": {"
                + "        \"AMT01\": \"D\","
                + "        \"AMT02\": \"1500.00\""
                + "    }"
                + "},"
//                + "\"Loop2330A\": {"
//                + "    \"NM1\": {"
//                + "        \"NM101\": \"MI\","
//                + "        \"NM109\": \"7865334256\""
//                + "    }"
//                + "},"
                + "\"Loop2330B\": {"
                + "    \"NM1\": {"
                + "        \"NM101\": \"DN\","
                + "        \"NM109\": \"7865334256\""
                + "    },"
                + "    \"DTP\": {"
                + "        \"DTP01\": \"573\","
                + "        \"DTP02\": \"D8\","
                + "        \"DTP03\": \"20230701\""
                + "    }"
                + "},"
                + "\"Loop2400\": ["
                + "    {"
                + "        \"LX\": {"
                + "            \"LX01\": \"1\""
                + "        },"
                + "        \"SV1\": {"
                + "            \"SV101-1\": \"HC\","
                + "            \"SV101-2\": \"99213\","
                + "            \"SV101-3\": \"Q6\","
                + "            \"SV102\": \"40\","
                + "            \"SV103\": \"UN\","
                + "            \"SV104\": \"2\","
                + "            \"SV105\": \"\","
                + "            \"SV106\": \"\","
                + "            \"SV107\": \"\","
                + "            \"SV108\": \"\","
                + "            \"SV109\": \"Y\","
                + "            \"SV110\": \"\","
                + "            \"SV111\": \"Y\","
                + "            \"SV112\": \"Y\""
                + "        },"
                + "        \"SV5\": {"
                + "            \"SV105-1\": \"HC\","
                + "            \"SV105-2\": \"H2017\""
                + "        },"
                + "        \"DTP\": {"
                + "            \"DTP01\": \"472\","
                + "            \"DTP02\": \"D8\","
                + "            \"DTP03\": \"20230903\""
                + "        }"
                + "    },"
                + "    {"
                + "        \"LX\": {"
                + "            \"LX01\": \"2\""
                + "        },"
                + "        \"SV1\": {"
                + "            \"SV101-1\": \"HC\","
                + "            \"SV101-2\": \"99214\","
                + "            \"SV102\": \"60\","
                + "            \"SV103\": \"UN\","
                + "            \"SV104\": \"1\","
                + "            \"SV105\": \"15\","
                + "            \"SV106\": \"\","
                + "            \"SV107\": \"N\","
                + "            \"SV109\": \"Y\","
                + "            \"SV110\": \"Y\""
                + "        },"
                + "        \"SV5\": {"
                + "            \"SV105-1\": \"HC\","
                + "            \"SV105-2\": \"H0004\""
                + "        },"
                + "        \"DTP\": {"
                + "            \"DTP01\": \"472\","
                + "            \"DTP02\": \"D8\","
                + "            \"DTP03\": \"20230903\""
                + "        }"
                + "    }"
                + "],"
                + "\"Loop2420A\": {"
                + "    \"NM1\": {"
                + "        \"NM108\": \"XX\","
                + "        \"NM109\": \"1881968584\""
                + "    },"
                + "    \"PRV\": {"
                + "        \"PRV02\": \"PXC\","
                + "        \"PRV03\": \"251S00000X\""
                + "    },"
                + "    \"REF\": {"
                + "        \"REF01\": \"G2\","
                + "        \"REF02\": \"1234567890\""
                + "    }"
                + "},"
                + "\"Loop2420E\": {"
                + "    \"NM1\": {"
                + "        \"NM108\": \"XX\","
                + "        \"NM109\": \"1881968584\""
                + "    },"
                + "    \"N4\": {"
                + "        \"N401\": \"Chicago\","
                + "        \"N402\": \"IL\","
                + "        \"N403\": \"300833107\""
                + "    },"
                + "    \"REF\": {"
                + "        \"REF01\": \"G2\","
                + "        \"REF02\": \"1234567890\""
                + "    }"
                + "},"
                + "\"Loop2420F\": {"
                + "    \"NM1\": {"
                + "        \"NM108\": \"XX\","
                + "        \"NM109\": \"1881968584\""
                + "    },"
                + "    \"REF\": {"
                + "        \"REF01\": \"G2\","
                + "        \"REF02\": \"1234567890\""
                + "    }"
                + "},"
                + "\"Loop2430\": {"
                + "    \"SVD\": {"
                + "        \"SVD01\": \"1234567890\","
                + "        \"SVD02\": \"100.00\""
                + "    },"
                + "    \"CAS\": {"
                + "            \"CAS01\": \"CO\","
                + "            \"CAS02\": \"45\","
                + "            \"CAS03\": \"50.00\","
                + "            \"CAS05\": \"45\","
                + "            \"CAS06\": \"50.00\""
                + "        }"
                + "},"
//                + "\"Loop2420D\": {"
//                + "    \"NM1\": {"
//                + "        \"NM108\": \"XX\","
//                + "        \"NM109\": \"7865334256\""
//                + "    },"
//                + "    \"REF\": {"
//                + "        \"REF01\": \"G2\","
//                + "        \"REF02\": \"KA66633452\""
//                + "    }"
//                + "},"
//                + "\"Loop2430\": {"
//                + "    \"SVD\": {"
//                + "        \"SVD01\": \"7865334256\","
//                + "        \"SVD02\": \"292.12\","
//                + "        \"SVD03-1\": \"HC\","
//                + "        \"SVD03-2\": \"H0004\""
//                + "    },"
//                + "    \"DTP\": {"
//                + "        \"DTP01\": \"573\","
//                + "        \"DTP02\": \"D8\","
//                + "        \"DTP03\": \"20230903\""
//                + "    },"
//                + "    \"CAS\": {"
//                + "        \"CAS02\": \"45\","
//                + "        \"CAS03\": \"$50.00\","
//                + "        \"CAS05\": \"100.00\","
//                + "        \"CAS06\": \"$50.00\""
//                + "    }"
//                + "},"
                + "\"SE\": {"
                + "    \"SE01\": \"10\","
                + "    \"SE02\": \"005010X222A1\""
                + "},"
                + "\"GE\": {"
                + "    \"GE01\": \"1\","
                + "    \"GE02\": \"000000001\""
                + "},"
                + "\"IEA\": {"
                + "    \"IEA01\": \"1\","
                + "    \"IEA02\": \"000000001\""
                + "}"
                + "}";

        ResponseEntity<String> responseEntity = convertJsonToEdi(jsonString);

        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            String ediString = responseEntity.getBody();
            System.out.println(ediString);
        } else {
            System.out.println("Error in conversion. Status code: " + responseEntity.getStatusCodeValue());
        }
    }

    @PostMapping("/convertJsonToEdi_837P")
    public static ResponseEntity<String> convertJsonToEdi(@RequestBody String jsonString) {
        try {
            globalEdiBuilder.setLength(0); // Clear the global EDI builder
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode parentNode = objectMapper.readTree(jsonString);

            // Process ISA Segment
            JsonNode isaNode = parentNode.path("ISA");
            if (!isaNode.isMissingNode()) {
                processEdiSegment("ISA", isaNode);
            }
            // Process GS Segment
            JsonNode gsNode = parentNode.path("GS");
            if (!gsNode.isMissingNode()) {
                processEdiSegment("GS", gsNode);
            }
            // Process ST Segment
            JsonNode stNode = parentNode.path("ST");
            if (!stNode.isMissingNode()) {
                processEdiSegment("ST", stNode);
            }
            // Process BHT Segment
            JsonNode bhtNode = parentNode.path("BHT");
            if (!bhtNode.isMissingNode()) {
                processEdiSegment("BHT", bhtNode);
            }
            // Process LOOP1000A Segment
            JsonNode loop1000ANode = parentNode.path("Loop1000A");
            if (!loop1000ANode.isMissingNode()) { // Ensure the Loop1000A node exists
                JsonNode nm1Node = loop1000ANode.path("NM1");
                if (!nm1Node.isMissingNode()) { // Check if the NM1 segment exists within Loop1000A
                    processEdiSegment("NM1", nm1Node);
                    JsonNode perNode = loop1000ANode.path("PER");
                    if (!perNode.isMissingNode()) { // Check if the PER segment exists within Loop1000A
                        processEdiSegment("PER", perNode);
                    }
                }
            }
            // Process LOOP1000B Segment
            JsonNode loop1000BNode = parentNode.path("Loop1000B");
            if (!loop1000BNode.isMissingNode()) { // Ensure the Loop1000B node exists
                JsonNode nm1Node = loop1000BNode.path("NM1");
                if (!nm1Node.isMissingNode()) { // Check if the NM1 segment exists within Loop1000B
                    processEdiSegment("NM1", nm1Node);
                }
            }
            // Process Loop2000A Segment
            JsonNode loop2000ANode = parentNode.path("Loop2000A");
            if (!loop2000ANode.isMissingNode()) { // Ensure the Loop2000A node exists
                // Process HL Segment within Loop2000A
                JsonNode hlNode = loop2000ANode.path("HL");
                if (!hlNode.isMissingNode()) { // Check if the HL segment exists within Loop2000A
                    processEdiSegment("HL", hlNode);

                    // Process PRV Segment within Loop2000A
                    JsonNode prvNode = loop2000ANode.path("PRV");
                    if (!prvNode.isMissingNode()) { // Check if the PRV segment exists within Loop2000A
                        processEdiSegment("PRV", prvNode);
                    }
                }
            }
            // Process Loop2010AA Segment within Loop2000A
            JsonNode loop2010AANode = parentNode.path("Loop2010AA");
            if (!loop2010AANode.isMissingNode()) { // Ensure the Loop2010AA node exists within Loop2000A
                // Process NM1 Segment within Loop2010AA
                JsonNode nm1Node = loop2010AANode.path("NM1");
                if (!nm1Node.isMissingNode()) { // Check if the NM1 segment exists within Loop2010AA
                    processEdiSegment("NM1", nm1Node);
                }

                // Process N3 Segment within Loop2010AA
                JsonNode n3Node = loop2010AANode.path("N3");
                if (!n3Node.isMissingNode()) { // Check if the N3 segment exists within Loop2010AA
                    processEdiSegment("N3", n3Node);
                }

                // Process N4 Segment within Loop2010AA
                JsonNode n4Node = loop2010AANode.path("N4");
                if (!n4Node.isMissingNode()) { // Check if the N4 segment exists within Loop2010AA
                    processEdiSegment("N4", n4Node);
                }

                // Process REF Segment within Loop2010AA
                JsonNode refNode = loop2010AANode.path("REF");
                if (!refNode.isMissingNode()) { // Check if the REF segment exists within Loop2010AA
                    processEdiSegment("REF", refNode);
                }
            }

            // Process LOOP2000B Segment
            JsonNode loop2000BNode = parentNode.path("Loop2000B");
            if (!loop2000BNode.isMissingNode()) { // Ensure the Loop2000B node exists
                // Process HL Segment within Loop2000B
                JsonNode hlNode = loop2000BNode.path("HL");
                if (!hlNode.isMissingNode()) { // Check if the HL segment exists within Loop2000B
                    processEdiSegment("HL", hlNode);
                }

                // Process SBR Segment within Loop2000B
                JsonNode sbrNode = loop2000BNode.path("SBR");
                if (!sbrNode.isMissingNode()) { // Check if the SBR segment exists within Loop2000B
                    processEdiSegment("SBR", sbrNode);
                }
            }
            // Process LOOP2010BA Segment
            JsonNode loop2010BANode = parentNode.path("Loop2010BA");
            if (!loop2010BANode.isMissingNode()) { // Ensure the Loop2010BA node exists
                // Process NM1 Segment within Loop2010BA
                JsonNode nm1Node = loop2010BANode.path("NM1");
                if (!nm1Node.isMissingNode()) { // Check if the NM1 segment exists within Loop2010BA
                    processEdiSegment("NM1", nm1Node);
                }

                // Process DMG Segment within Loop2010BA
                JsonNode dmgNode = loop2010BANode.path("DMG");
                if (!dmgNode.isMissingNode()) { // Check if the DMG segment exists within Loop2010BA
                    processEdiSegment("DMG", dmgNode);
                }
            }

            // Process LOOP2010BB Segment
            JsonNode loop2010BBNode = parentNode.path("Loop2010BB");
            if (!loop2010BBNode.isMissingNode()) { // Ensure the Loop2010BB node exists
                // Process NM1 Segment within Loop2010BB
                JsonNode nm1Node = loop2010BBNode.path("NM1");
                if (!nm1Node.isMissingNode()) { // Check if the NM1 segment exists within Loop2010BB
                    processEdiSegment("NM1", nm1Node);
                }
                // Process N4 Segment within Loop2010BB
                JsonNode n4Node = loop2010BBNode.path("N4");
                if (!n4Node.isMissingNode()) { // Check if the N4 segment exists within Loop2010BB
                    processEdiSegment("N4", n4Node);
                }
                // Process REF Segment within Loop2010BB
                JsonNode refNode = loop2010BBNode.path("REF");
                if (!refNode.isMissingNode()) { // Check if the REF segment exists within Loop2010BB
                    processEdiSegment("REF", refNode);
                }
            }

            // Process LOOP2000C Segment
            JsonNode loop2000CNode = parentNode.path("Loop2000C");
            if (!loop2000CNode.isMissingNode()) { // Ensure the Loop2000C node exists
                // Process HL Segment within Loop2000C
                JsonNode hlNode = loop2000CNode.path("HL");
                if (!hlNode.isMissingNode()) { // Check if the HL segment exists within Loop2000C
                    processEdiSegment("HL", hlNode);
                }

                // Process PAT Segment within Loop2000C
                JsonNode patNode = loop2000CNode.path("PAT");
                if (!patNode.isMissingNode()) { // Check if the PAT segment exists within Loop2000C
                    processEdiSegment("PAT", patNode);
                }
            }
            // Process LOOP2010CA Segment
            JsonNode loop2010CANode = parentNode.path("Loop2010CA");
            if (!loop2010CANode.isMissingNode()) { // Ensure the Loop2010CA node exists
                // Process NM1 Segment within Loop2010CA
                JsonNode nm1Node = loop2010CANode.path("NM1");
                if (!nm1Node.isMissingNode()) { // Check if the NM1 segment exists within Loop2010CA
                    processEdiSegment("NM1", nm1Node);
                }
                // Process N3 Segment within Loop2010CA
                JsonNode n3Node = loop2010CANode.path("N3");
                if (!n3Node.isMissingNode()) { // Check if the N3 segment exists within Loop2010CA
                    processEdiSegment("N3", n3Node);
                }

                // Process N4 Segment within Loop2010CA
                JsonNode n4Node = loop2010CANode.path("N4");
                if (!n4Node.isMissingNode()) { // Check if the N4 segment exists within Loop2010CA
                    processEdiSegment("N4", n4Node);
                }
                // Process DMG Segment within Loop2010CA
                JsonNode dmgNode = loop2010CANode.path("DMG");
                if (!dmgNode.isMissingNode()) { // Check if the DMG segment exists within Loop2010CA
                    processEdiSegment("DMG", dmgNode);
                }
            }
            // Process Loop2300 Segment
            JsonNode loop2300Node = parentNode.path("Loop2300");
            if (!loop2300Node.isMissingNode()) { // Ensure the Loop2300 node exists
                // Process CLM Segment
                JsonNode clmNode = loop2300Node.path("CLM");
                if (!clmNode.isMissingNode()) { // Check if the CLM segment exists within Loop2300
                    processEdiSegment("CLM", clmNode);
                }

                // Process DTP Segments within Loop2300
                JsonNode dtpArray = loop2300Node.path("DTP");
                if (dtpArray.isArray()) {
                    for (JsonNode dtpNode : dtpArray) {
                        processEdiSegment("DTP", dtpNode);
                    }
                }

                processEdiSegment("CL1", loop2300Node.path("CL1"));
                processEdiSegment("CN1", loop2300Node.path("CN1"));

                // Process REF Segments within Loop2300
                JsonNode refArray = loop2300Node.path("REF");
                if (refArray.isArray()) {
                    for (JsonNode refNode : refArray) {
                        processEdiSegment("REF", refNode);
                    }
                }

                // Process HI Segments within Loop2300
                JsonNode hiArray = loop2300Node.path("HI");
                if (hiArray.isArray()) {
                    for (JsonNode hiNode : hiArray) {
                        processEdiSegment("HI", hiNode);
                    }
                }
            }
            // Process LOOP2310A Segment
            JsonNode loop2310ANode = parentNode.path("Loop2310A");
            if (!loop2310ANode.isMissingNode()) { // Ensure the Loop2310A node exists
                // Process NM1 Segment within Loop2310A
                JsonNode nm1Node = loop2310ANode.path("NM1");
                if (!nm1Node.isMissingNode()) { // Check if the NM1 segment exists within Loop2310A
                    processEdiSegment("NM1", nm1Node);
                }
            }
            // Process LOOP2310B Segment
            JsonNode loop2310BNode = parentNode.path("Loop2310B");
            if (!loop2310BNode.isMissingNode()) { // Ensure the Loop2310B node exists
                // Process NM1 Segment within Loop2310B
                JsonNode nm1Node = loop2310BNode.path("NM1");
                if (!nm1Node.isMissingNode()) { // Check if the NM1 segment exists within Loop2310B
                    processEdiSegment("NM1", nm1Node);
                }
                JsonNode prvNode = loop2310BNode.path("PRV");
                if (!prvNode.isMissingNode()) { // Check if the PRV segment exists within Loop2310B
                    processEdiSegment("PRV", prvNode);
                }
            }
            // Process LOOP2310C Segment
            JsonNode loop2310CNode = parentNode.path("Loop2310C");
            if (!loop2310CNode.isMissingNode()) { // Ensure the Loop2310C node exists
                // Process NM1 Segment within Loop2310C
                JsonNode nm1Node = loop2310CNode.path("NM1");
                if (!nm1Node.isMissingNode()) { // Check if the NM1 segment exists within Loop2310C
                    processEdiSegment("NM1", nm1Node);
                }
            }
            // Process LOOP2310E Segment
            JsonNode loop2310ENode = parentNode.path("Loop2310E");
            if (!loop2310ENode.isMissingNode()) { // Ensure the Loop2310E node exists
                // Process NM1 Segment within Loop2310E
                JsonNode nm1Node = loop2310ENode.path("NM1");
                if (!nm1Node.isMissingNode()) { // Check if the NM1 segment exists within Loop2310E
                    processEdiSegment("NM1", nm1Node);
                }
                // Process N3 Segment within Loop2310E
                JsonNode n3Node = loop2310ENode.path("N3");
                if (!n3Node.isMissingNode()) { // Check if the N3 segment exists within Loop2310E
                    processEdiSegment("N3", n3Node);
                }

                // Process N4 Segment within Loop2310E
                JsonNode n4Node = loop2310ENode.path("N4");
                if (!n4Node.isMissingNode()) { // Check if the N4 segment exists within Loop2310E
                    processEdiSegment("N4", n4Node);
                }

                // Process REF Segment within Loop2310E
                JsonNode refNode = loop2310ENode.path("REF");
                if (!refNode.isMissingNode()) { // Check if the REF segment exists within Loop2310E
                    processEdiSegment("REF", refNode);
                }
            }
            // Process LOOP2310F Segment
            JsonNode loop2310FNode = parentNode.path("Loop2310F");
            if (!loop2310FNode.isMissingNode()) { // Ensure the Loop2310F node exists
                // Process NM1 Segment within Loop2310F
                JsonNode nm1Node = loop2310FNode.path("NM1");
                if (!nm1Node.isMissingNode()) { // Check if the NM1 segment exists within Loop2310F
                    processEdiSegment("NM1", nm1Node);
                }
                // Process N3 Segment within Loop2310F
                JsonNode n3Node = loop2310FNode.path("N3");
                if (!n3Node.isMissingNode()) { // Check if the N3 segment exists within Loop2310F
                    processEdiSegment("N3", n3Node);
                }

                // Process N4 Segment within Loop2310F
                JsonNode n4Node = loop2310FNode.path("N4");
                if (!n4Node.isMissingNode()) { // Check if the N4 segment exists within Loop2310F
                    processEdiSegment("N4", n4Node);
                }

                // Process REF Segment within Loop2310F
                JsonNode refNode = loop2310FNode.path("REF");
                if (!refNode.isMissingNode()) { // Check if the REF segment exists within Loop2310F
                    processEdiSegment("REF", refNode);
                }
            }
            // Process LOOP2320 Segment
            JsonNode loop2320Node = parentNode.path("Loop2320");
            if (!loop2320Node.isMissingNode()) { // Ensure the Loop2320 node exists
                // Process SBR Segment within Loop2320
                JsonNode sbrNode = loop2320Node.path("SBR");
                if (!sbrNode.isMissingNode()) { // Check if the SBR segment exists within Loop2320
                    processEdiSegment("SBR", sbrNode);
                }
                // Process CAS Segment within Loop2320
                JsonNode casNode = loop2320Node.path("CAS");
                if (!casNode.isMissingNode()) { // Check if the CAS segment exists within Loop2320
                    processEdiSegment("CAS", casNode);
                }
                // Process AMT Segment within Loop2320
                JsonNode amtNode = loop2320Node.path("AMT");
                if (!amtNode.isMissingNode()) { // Check if the AMT segment exists within Loop2320
                    processEdiSegment("AMT", amtNode);
                }
            }
            // Process LOOP2330A Segment
            JsonNode loop2330ANode = parentNode.path("Loop2330A");
            if (!loop2330ANode.isMissingNode()) { // Ensure the Loop2330A node exists
                // Process NM1 Segment within Loop2330A
                JsonNode nm1Node = loop2330ANode.path("NM1");
                if (!nm1Node.isMissingNode()) { // Check if the NM1 segment exists within Loop2330A
                    processEdiSegment("NM1", nm1Node);
                }
            }
            // Process LOOP2330B Segment
            JsonNode loop2330BNode = parentNode.path("Loop2330B");
            if (!loop2330BNode.isMissingNode()) { // Ensure the Loop2330B node exists
                // Process NM1 Segment within Loop2330B
                JsonNode nm1Node = loop2330BNode.path("NM1");
                if (!nm1Node.isMissingNode()) { // Check if the NM1 segment exists within Loop2330B
                    processEdiSegment("NM1", nm1Node);
                }
                // Process DTP Segment within Loop2330B
                JsonNode dtpNode = loop2330BNode.path("DTP");
                if (!dtpNode.isMissingNode()) { // Check if the DTP segment exists within Loop2330B
                    processEdiSegment("DTP", dtpNode);
                }
            }
            // Process Loop2400 Segment
            JsonNode loop2400Node = parentNode.path("Loop2400");
            if (!loop2400Node.isMissingNode() && loop2400Node.isArray()) {
                for (JsonNode loop2400Item : loop2400Node) {
                    // Process LX Segment
                    JsonNode lxNode = loop2400Item.path("LX");
                    if (!lxNode.isMissingNode()) {
                        processEdiSegment("LX", lxNode);
                    }

                    // Process SV1 Segment
                    JsonNode sv1Node = loop2400Item.path("SV1");
                    if (!sv1Node.isMissingNode()) {
                        processEdiSegment("SV1", sv1Node);
                    }

                    // Process SV5 Segment
                    JsonNode sv5Node = loop2400Item.path("SV5");
                    if (!sv5Node.isMissingNode()) {
                        String sv5Output = String.format("SV5*%s:%s~", sv5Node.path("SV105-1").asText(), sv5Node.path("SV105-2").asText());
                        appendToGlobalVariable(sv5Output);
                    }

                    // Process DTP Segment
                    JsonNode dtpNode = loop2400Item.path("DTP");
                    if (!dtpNode.isMissingNode()) {
                        processEdiSegment("DTP", dtpNode);
                    }
                }
            }

            // Process LOOP2420A Segment
            JsonNode loop2420ANode = parentNode.path("Loop2420A");
            if (!loop2420ANode.isMissingNode()) { // Ensure the Loop2420A node exists
                // Process NM1 Segment within Loop2420A
                JsonNode nm1Node = loop2420ANode.path("NM1");
                if (!nm1Node.isMissingNode()) { // Check if the NM1 segment exists within Loop2420A
                    processEdiSegment("NM1", nm1Node);
                }
                // Process PRV Segment within Loop2420A
                JsonNode prvNode = loop2420ANode.path("PRV");
                if (!prvNode.isMissingNode()) { // Check if the PRV segment exists within Loop2420A
                    processEdiSegment("PRV", prvNode);
                }
                // Process REF Segment within Loop2420A
                JsonNode refNode = loop2420ANode.path("REF");
                if (!refNode.isMissingNode()) { // Check if the REF segment exists within Loop2420A
                    processEdiSegment("REF", refNode);
                }
            }

            // Process Loop2420D Segment
            JsonNode loop2420DNode = parentNode.path("Loop2420D");
            if (!loop2420DNode.isMissingNode()) { // Ensure the Loop2420D node exists
                // Process NM1 Segment within Loop2420D
                JsonNode nm1Node = loop2420DNode.path("NM1");
                if (!nm1Node.isMissingNode()) { // Check if the NM1 segment exists within Loop2420D
                    processEdiSegment("NM1", nm1Node);
                }

                // Process REF Segment within Loop2420D
                JsonNode refNode = loop2420DNode.path("REF");
                if (!refNode.isMissingNode()) { // Check if the REF segment exists within Loop2420D
                    processEdiSegment("REF", refNode);
                }
            }

            // Process LOOP2420E Segment
            JsonNode loop2420ENode = parentNode.path("Loop2420E");
            if (!loop2420ENode.isMissingNode()) { // Ensure the Loop2420E node exists
                // Process NM1 Segment within Loop2420E
                JsonNode nm1Node = loop2420ENode.path("NM1");
                if (!nm1Node.isMissingNode()) { // Check if the NM1 segment exists within Loop2420E
                    processEdiSegment("NM1", nm1Node);
                }
                // Process N4 Segment within Loop2420E
                JsonNode n4Node = loop2420ENode.path("N4");
                if (!n4Node.isMissingNode()) { // Check if the N4 segment exists within Loop2420E
                    processEdiSegment("N4", n4Node);
                }
                // Process REF Segment within Loop2420E
                JsonNode refNode = loop2420ENode.path("REF");
                if (!refNode.isMissingNode()) { // Check if the REF segment exists within Loop2420E
                    processEdiSegment("REF", refNode);
                }
            }

// Process LOOP2420F Segment
            JsonNode loop2420FNode = parentNode.path("Loop2420F");
            if (!loop2420FNode.isMissingNode()) { // Ensure the Loop2420F node exists
                // Process NM1 Segment within Loop2420F
                JsonNode nm1Node = loop2420FNode.path("NM1");
                if (!nm1Node.isMissingNode()) { // Check if the NM1 segment exists within Loop2420F
                    processEdiSegment("NM1", nm1Node);
                }
                // Process REF Segment within Loop2420F
                JsonNode refNode = loop2420FNode.path("REF");
                if (!refNode.isMissingNode()) { // Check if the REF segment exists within Loop2420F
                    processEdiSegment("REF", refNode);
                }
            }

// Process LOOP2430 Segment
            JsonNode loop2430Node = parentNode.path("Loop2430");
            if (!loop2430Node.isMissingNode()) { // Ensure the Loop2430 node exists
                // Process SVD Segment within Loop2430
                JsonNode svdNode = loop2430Node.path("SVD");
                if (!svdNode.isMissingNode()) { // Check if the SVD segment exists within Loop2430
                    processEdiSegment("SVD", svdNode);
                }
                // Process CAS Segment within Loop2430
                JsonNode casNode = loop2430Node.path("CAS");
                if (!casNode.isMissingNode()) { // Check if the CAS segment exists within Loop2430
                    processEdiSegment("CAS", casNode);
                }
            }




            // Process Loop2430 Segment
//            JsonNode loop2430Node = parentNode.path("Loop2430");
//            if (!loop2430Node.isMissingNode()) { // Ensure the Loop2430 node exists
//                // Process SVD Segment within Loop2430
//                JsonNode svdNode = loop2430Node.path("SVD");
//                if (!svdNode.isMissingNode()) { // Check if the SVD segment exists within Loop2430
//                    processEdiSegment("SVD", svdNode);
//                }
//
//                // Process DTP Segment within Loop2430
//                JsonNode dtpNode = loop2430Node.path("DTP");
//                if (!dtpNode.isMissingNode()) { // Check if the DTP segment exists within Loop2430
//                    processEdiSegment("DTP", dtpNode);
//                }
//
//                // Process CAS Segment within Loop2430
//                JsonNode casNode = loop2430Node.path("CAS");
//                if (!casNode.isMissingNode()) { // Check if the CAS segment exists within Loop2430
//                    processEdiSegment("CAS", casNode);
//                }
//            }

            // Process SE Segment
            JsonNode seNode = parentNode.path("SE");
            if (!seNode.isMissingNode()) { // Check if the SE segment exists
                processEdiSegment("SE", seNode);
            }

            // Process GE Segment
            JsonNode geNode = parentNode.path("GE");
            if (!geNode.isMissingNode()) { // Check if the GE segment exists
                processEdiSegment("GE", geNode);
            }

            // Process IEA Segment
            JsonNode ieaNode = parentNode.path("IEA");
            if (!ieaNode.isMissingNode()) { // Check if the IEA segment exists
                processEdiSegment("IEA", ieaNode);
            }

            return ResponseEntity.ok(globalEdiBuilder.toString());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error converting JSON to EDI");
        }
    }

    private static void processSegment(JsonNode parentNode, String segmentName) {
        JsonNode segmentNode = parentNode.path(segmentName);
        if (!segmentNode.isMissingNode()) {
            processEdiSegment(segmentName, segmentNode);
        }
    }

    private static void processEdiSegment(String segmentName, JsonNode segmentNode) {
        if (!segmentNode.isMissingNode()) {
            StringBuilder segmentBuilder = new StringBuilder(segmentName);
            segmentNode.fields().forEachRemaining(field -> {
                appendFieldValues(segmentBuilder, field.getValue());
            });
            segmentBuilder.append("~\n");
            globalEdiBuilder.append(segmentBuilder);
        }
    }

    private static void appendFieldValues(StringBuilder segmentBuilder, JsonNode node) {
        if (node.isObject()) {
            node.fields().forEachRemaining(field -> appendFieldValues(segmentBuilder, field.getValue()));
        } else {
            segmentBuilder.append("*").append(node.asText());
        }
    }
}