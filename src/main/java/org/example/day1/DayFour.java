package org.example.day1;

import java.util.Arrays;

public class DayFour implements Day {

    private Integer getIntValue(String val) {
        return Integer.parseInt(val);
    }

    @Override
    public String process() {

        int total = Arrays
                .stream(rawData().split("\n"))
                .mapToInt(s -> {
                    String[] elfPairSplitted = s.split(",");
                    String[] elfOnePair = elfPairSplitted[0].split("-");
                    String[] elfTwoPair = elfPairSplitted[1].split("-");

                    // 3-4, 5-6
                    // 4-5, 3-7
                    if (getIntValue(elfOnePair[0]) >= getIntValue(elfTwoPair[0]) && getIntValue(elfOnePair[1]) <= getIntValue(elfTwoPair[1])) {
                        // First Contained
                        return 1;
                    } else if (getIntValue(elfTwoPair[0]) >= getIntValue(elfOnePair[0]) && getIntValue(elfTwoPair[1]) <= getIntValue(elfOnePair[1])) {
                        // Second Contained
                        return 1;
                    } else {
                        return 0;
                    }

                })
                .sum();

        return String.format("Total %s", total);
    }

    @Override
    public String processMore() {
        return null;
    }

    @Override
    public String rawData() {
        return """
                35-73,35-82
                9-27,10-80
                25-93,2-42
                37-54,52-53
                3-8,2-97
                46-89,45-49
                52-76,75-75
                26-27,21-27
                22-96,21-80
                98-99,6-99
                4-9,8-91
                32-46,39-54
                14-14,15-51
                49-56,65-87
                16-16,16-33
                63-96,95-97
                3-81,3-96
                3-69,3-68
                9-93,11-93
                3-8,8-94
                94-97,5-92
                35-73,53-73
                17-17,17-84
                88-88,5-89
                11-99,12-62
                31-33,23-34
                98-98,10-99
                26-26,26-86
                21-63,22-50
                44-81,20-45
                40-41,16-42
                1-39,38-40
                33-97,97-97
                8-9,8-77
                3-76,2-75
                71-82,71-81
                65-85,84-86
                13-71,12-14
                57-95,28-96
                10-35,3-35
                4-99,98-99
                53-60,54-85
                39-43,16-43
                1-86,85-86
                6-7,6-35
                3-3,4-69
                15-72,3-16
                25-48,24-48
                12-33,12-34
                61-63,8-62
                76-76,59-77
                18-82,81-81
                83-91,24-87
                2-2,9-9
                29-94,29-29
                41-87,41-93
                43-44,44-81
                9-83,82-83
                78-97,9-97
                11-26,12-49
                2-20,1-72
                29-97,28-88
                54-73,30-55
                30-77,96-97
                4-62,62-62
                25-60,60-60
                12-89,4-99
                96-98,4-83
                20-68,12-14
                76-76,19-76
                2-93,5-93
                64-64,46-65
                14-61,14-15
                19-85,18-86
                4-85,16-85
                88-88,15-89
                66-66,66-73
                1-93,1-2
                16-81,10-81
                79-89,3-88
                57-94,79-95
                52-52,12-53
                13-27,27-27
                13-13,14-14
                82-84,22-82
                68-93,25-69
                43-85,44-85
                2-27,24-75
                34-44,31-43
                6-47,12-54
                43-75,42-74
                12-91,7-90
                48-54,53-66
                40-54,53-90
                11-61,12-95
                16-86,17-85
                10-94,11-11
                86-88,4-87
                17-94,16-93
                16-55,15-17
                29-50,28-49
                12-75,13-76
                27-37,33-36
                9-9,9-95
                47-99,98-98
                35-87,87-87
                38-99,39-99
                5-58,16-57
                84-86,84-88
                73-75,74-76
                10-92,11-92
                6-51,50-52
                3-21,20-21
                15-55,14-15
                50-50,50-98
                5-55,6-66
                44-97,86-96
                2-62,3-63
                3-98,1-99
                32-75,75-76
                71-71,70-79
                46-89,5-61
                79-95,80-94
                71-88,69-89
                49-72,48-80
                3-56,8-76
                10-79,12-89
                33-97,33-96
                41-91,90-90
                32-44,31-32
                25-52,45-47
                38-57,38-57
                88-88,13-89
                23-45,22-44
                12-93,13-69
                76-76,27-77
                16-17,16-24
                16-92,91-93
                8-95,8-85
                4-64,3-65
                18-94,17-34
                43-52,43-52
                16-97,15-95
                10-39,15-38
                33-33,10-34
                35-56,34-48
                97-99,41-95
                45-49,44-49
                5-94,7-94
                2-98,1-7
                17-73,16-74
                11-20,9-12
                27-27,26-64
                5-93,8-92
                16-77,16-76
                58-90,93-94
                36-59,40-59
                72-84,72-84
                2-81,4-95
                31-63,32-76
                4-88,4-5
                18-20,19-87
                84-84,84-95
                26-76,75-75
                7-79,42-79
                29-37,23-29
                28-51,28-50
                38-65,8-39
                55-89,56-90
                6-6,6-49
                14-18,23-43
                61-70,2-70
                5-92,92-92
                6-71,7-75
                41-59,42-59
                99-99,7-46
                15-50,51-57
                17-95,16-17
                54-88,55-87
                36-36,36-73
                79-87,27-79
                38-85,32-39
                91-93,41-92
                71-75,52-74
                37-52,37-53
                33-67,4-68
                27-94,27-99
                12-90,89-90
                7-70,6-69
                97-99,96-98
                91-95,7-92
                23-95,24-74
                8-35,34-53
                26-94,26-94
                90-90,71-91
                8-16,7-15
                3-97,3-98
                23-23,22-24
                25-65,24-40
                24-24,13-25
                1-83,3-82
                10-11,10-65
                40-41,41-41
                91-91,2-92
                70-95,94-95
                2-86,3-83
                10-12,11-93
                77-90,38-71
                25-25,12-26
                75-77,5-76
                9-85,7-10
                7-94,87-93
                95-95,41-96
                51-75,50-52
                40-87,41-41
                23-47,47-72
                21-98,20-98
                10-63,10-53
                68-82,68-68
                18-78,18-50
                29-60,33-96
                2-53,9-53
                5-97,1-5
                23-49,48-78
                23-70,23-24
                4-95,3-96
                14-35,13-34
                41-67,40-40
                4-96,3-81
                54-55,54-70
                7-79,18-81
                61-71,61-70
                9-9,9-76
                69-91,69-92
                10-90,11-95
                95-97,67-96
                85-94,86-91
                70-73,68-73
                23-76,92-99
                1-12,11-94
                46-77,46-78
                65-73,52-72
                27-62,28-98
                30-76,73-75
                5-45,5-71
                11-90,89-89
                14-92,14-15
                62-75,61-87
                25-88,84-94
                16-84,17-95
                18-93,17-93
                27-59,27-27
                36-43,36-42
                42-42,43-56
                7-41,40-41
                6-95,6-7
                23-98,12-98
                6-87,52-88
                54-62,53-68
                33-86,18-37
                2-98,12-98
                78-96,73-81
                93-97,93-96
                7-7,6-91
                34-49,34-48
                43-65,61-66
                57-72,67-98
                16-89,15-89
                3-66,2-65
                21-45,22-31
                7-47,47-54
                1-78,1-79
                31-77,32-77
                88-91,18-88
                15-82,11-16
                37-90,20-90
                18-52,21-81
                1-96,2-96
                6-54,5-25
                20-46,17-47
                2-7,7-94
                10-42,16-43
                25-43,26-56
                11-99,11-12
                4-95,3-94
                61-63,69-88
                1-93,37-99
                94-94,14-95
                4-43,3-46
                79-98,78-78
                2-78,2-78
                48-72,48-72
                10-98,3-99
                22-47,35-54
                8-62,9-16
                2-22,3-8
                4-93,5-91
                3-84,72-84
                18-32,18-19
                40-65,51-64
                34-36,34-34
                11-65,12-64
                23-98,24-97
                23-75,74-75
                4-6,5-72
                5-89,5-88
                25-86,85-87
                65-91,2-91
                93-94,2-81
                11-54,23-54
                57-94,93-99
                18-23,22-23
                88-88,4-87
                97-97,1-98
                6-99,5-5
                15-49,16-48
                41-68,68-68
                40-88,89-89
                89-91,7-90
                5-87,52-86
                31-39,32-38
                98-99,1-99
                36-49,48-49
                15-61,14-41
                41-53,42-63
                2-21,12-20
                37-47,47-47
                21-21,22-94
                48-65,49-69
                38-80,10-39
                7-7,7-85
                32-85,32-33
                42-79,78-78
                22-92,21-23
                1-35,3-47
                6-92,7-93
                40-94,6-87
                48-96,8-95
                45-95,79-94
                1-92,9-89
                21-64,20-65
                7-76,7-8
                1-59,3-45
                9-9,8-85
                16-32,31-70
                56-93,56-56
                8-15,13-89
                43-43,42-60
                31-73,6-74
                24-24,20-25
                36-72,36-37
                74-96,75-75
                6-94,5-93
                13-97,5-14
                10-22,22-22
                39-86,39-39
                75-75,75-83
                25-76,14-77
                9-67,66-66
                6-25,24-26
                8-8,15-62
                23-61,8-61
                32-34,6-33
                38-78,77-79
                52-77,53-77
                17-86,9-12
                88-90,2-89
                10-25,15-26
                25-86,24-24
                35-92,40-91
                19-79,83-86
                1-1,4-64
                66-72,71-79
                43-45,42-44
                7-93,6-89
                1-75,1-76
                7-8,7-99
                11-54,10-44
                5-6,1-6
                24-41,5-25
                7-93,7-85
                96-96,71-93
                41-84,41-83
                50-72,65-81
                23-24,23-77
                7-97,3-62
                26-26,25-32
                36-65,30-66
                83-83,77-82
                10-75,74-75
                10-90,11-89
                98-99,19-99
                98-99,1-94
                7-39,14-39
                8-8,9-91
                27-77,26-26
                22-78,36-78
                51-67,67-68
                12-35,11-49
                27-61,60-62
                23-51,26-94
                48-79,49-96
                13-95,6-39
                75-84,76-80
                18-67,19-68
                51-76,46-76
                40-93,33-41
                37-80,66-90
                16-50,15-95
                6-81,5-7
                10-94,9-65
                42-96,43-97
                16-71,17-72
                1-38,36-39
                62-63,62-86
                5-99,1-99
                71-72,8-72
                4-35,2-36
                1-52,51-53
                70-80,79-81
                46-47,47-82
                29-65,40-67
                42-60,35-54
                39-74,7-74
                74-97,4-97
                62-97,55-75
                8-36,7-35
                31-75,74-81
                12-34,11-85
                49-79,14-50
                52-53,53-63
                93-94,62-85
                85-93,13-87
                60-61,62-95
                2-5,4-80
                60-61,60-98
                24-58,24-59
                13-67,14-80
                13-80,14-81
                6-36,5-73
                9-76,80-81
                11-96,11-98
                20-97,88-98
                6-78,5-77
                7-7,19-47
                35-41,84-88
                57-59,44-59
                24-55,24-54
                13-80,13-14
                5-6,5-42
                51-90,52-52
                18-92,19-93
                20-20,23-94
                91-91,23-90
                22-77,98-98
                14-33,15-96
                28-34,28-29
                26-73,96-96
                45-86,44-87
                40-95,21-93
                15-20,14-14
                5-99,2-99
                89-89,23-88
                35-92,73-92
                92-92,36-93
                6-70,16-70
                18-85,19-85
                44-51,43-56
                17-88,16-48
                7-94,8-96
                90-90,34-83
                53-66,68-70
                19-82,18-81
                10-91,9-91
                22-76,31-77
                55-55,15-55
                2-61,2-3
                18-75,37-74
                36-95,35-37
                57-65,64-66
                89-91,10-90
                35-40,34-35
                6-90,6-6
                6-27,17-85
                9-10,10-30
                7-85,8-84
                60-60,34-60
                74-75,20-76
                58-94,7-93
                83-98,14-93
                10-86,9-62
                46-87,76-87
                34-73,34-74
                35-66,13-66
                99-99,4-93
                56-83,52-83
                3-90,2-98
                34-97,33-87
                71-71,10-71
                4-8,8-96
                81-89,17-81
                46-96,46-95
                20-34,19-32
                77-89,71-74
                18-71,19-20
                43-88,44-85
                40-94,40-40
                7-73,72-73
                98-99,50-97
                8-45,7-46
                33-73,33-73
                38-97,96-96
                24-86,24-87
                17-54,17-17
                46-84,43-84
                5-92,4-31
                58-93,99-99
                33-35,34-98
                43-74,36-49
                9-76,10-83
                4-93,3-92
                67-83,66-89
                17-54,15-17
                86-89,88-89
                16-50,4-51
                10-11,9-11
                41-94,94-94
                58-74,59-92
                19-35,34-36
                4-5,4-99
                38-75,56-76
                50-84,58-85
                1-35,34-35
                36-37,37-89
                1-47,15-95
                67-68,67-69
                50-94,93-98
                59-59,37-59
                62-63,63-79
                31-98,30-82
                32-91,31-92
                3-91,5-91
                1-1,2-92
                19-42,18-44
                62-70,22-64
                79-87,79-86
                3-86,2-2
                88-92,52-95
                3-49,1-7
                9-60,10-70
                70-94,40-71
                15-43,16-44
                62-94,93-94
                19-64,24-64
                7-75,74-99
                14-14,15-60
                9-71,9-71
                4-80,2-81
                39-78,49-78
                1-98,5-98
                1-14,2-44
                7-20,6-19
                41-41,40-84
                90-95,90-90
                11-16,15-45
                11-82,81-83
                20-73,15-73
                50-62,50-61
                11-88,12-95
                76-76,15-77
                4-6,5-64
                88-88,47-89
                68-81,8-69
                80-82,81-81
                54-93,20-56
                56-65,64-85
                50-90,15-90
                39-89,1-58
                50-77,76-78
                1-84,2-90
                46-87,45-87
                7-61,60-60
                35-99,36-80
                98-99,6-99
                53-62,33-54
                44-94,2-76
                2-93,4-93
                2-36,2-36
                74-76,6-75
                20-77,21-83
                8-9,8-97
                37-84,37-83
                11-54,54-54
                39-99,38-98
                17-37,33-76
                98-98,5-99
                33-66,34-59
                38-44,37-74
                54-59,59-59
                7-31,6-57
                14-19,15-44
                11-77,1-10
                26-70,27-70
                60-71,48-76
                45-50,49-92
                21-95,3-90
                63-79,64-99
                1-97,4-96
                28-69,30-68
                39-86,85-85
                28-28,3-29
                55-55,56-94
                31-87,30-31
                75-77,74-76
                19-19,19-99
                81-89,82-86
                37-68,16-68
                65-89,5-61
                71-97,72-96
                18-31,30-82
                74-96,75-75
                37-87,38-86
                13-46,13-14
                64-99,41-86
                50-95,49-97
                73-82,49-81
                13-39,22-40
                6-68,6-68
                51-88,51-90
                5-99,2-3
                99-99,73-96
                36-82,53-82
                12-79,13-79
                54-56,16-55
                7-52,15-63
                17-30,18-30
                21-59,22-59
                55-77,54-77
                5-81,4-4
                13-75,9-59
                42-53,52-52
                15-51,52-52
                8-31,7-7
                76-84,7-77
                22-99,22-23
                2-90,2-2
                32-73,72-72
                10-36,36-36
                30-52,53-79
                9-9,6-8
                91-94,1-95
                72-78,24-73
                40-86,85-87
                53-97,53-98
                15-49,25-49
                12-96,4-96
                17-97,99-99
                29-74,73-74
                64-98,63-99
                87-94,93-93
                2-90,5-89
                4-88,97-98
                10-77,11-78
                6-68,4-6
                16-64,11-21
                3-28,5-77
                29-87,29-88
                56-80,9-56
                2-41,40-46
                48-49,48-64
                46-46,5-46
                37-65,64-64
                6-53,7-54
                10-31,18-62
                47-56,53-56
                5-97,96-98
                18-97,19-57
                50-83,23-84
                47-57,2-58
                26-70,11-71
                26-28,27-80
                1-99,3-98
                80-91,79-81
                16-24,10-21
                5-98,6-97
                36-71,37-72
                67-69,2-68
                14-99,14-90
                33-72,23-34
                8-85,12-85
                4-77,3-67
                22-24,13-23
                27-90,22-28
                20-87,8-82
                73-74,29-74
                99-99,9-39
                14-64,65-65
                18-68,14-69
                24-43,42-96
                98-99,38-99
                4-7,6-83
                1-12,13-93
                16-38,2-39
                36-87,21-29
                24-26,76-92
                6-69,7-7
                8-22,4-11
                33-79,31-80
                73-73,72-73
                36-48,37-48
                6-9,8-80
                1-36,1-1
                5-33,33-33
                89-96,26-89
                42-54,43-56
                40-49,39-49
                60-60,61-81
                66-95,65-65
                5-96,6-6
                24-75,23-76
                82-89,32-45
                17-21,21-61
                39-66,39-40
                3-93,4-94
                10-35,9-79
                65-94,64-64
                77-77,76-76
                29-94,28-76
                10-83,11-84
                1-13,12-12
                92-92,39-93
                87-89,52-88
                55-70,55-71
                21-21,20-22
                2-99,98-99
                3-34,25-84
                58-68,58-69
                5-92,24-91
                1-55,2-66
                5-97,97-99
                49-56,48-50
                62-77,1-76
                27-73,28-73
                66-74,58-74
                4-38,1-38
                69-69,69-76
                8-95,9-97
                84-97,83-96
                24-26,12-25
                34-36,35-37
                28-50,28-49
                37-93,4-94
                42-94,20-95
                7-9,9-86
                2-5,10-85
                29-45,45-99
                59-74,56-74
                68-93,97-99
                10-10,9-9
                9-72,8-69
                52-52,21-53
                75-88,7-76
                3-90,4-99
                16-92,10-92
                1-96,95-98
                10-78,11-79
                28-58,29-59
                11-60,17-61
                33-97,32-95
                5-46,43-50
                27-96,26-66
                8-38,38-94
                19-61,61-61
                24-58,71-90
                13-96,10-14
                47-88,47-87
                77-99,44-98
                2-4,1-34
                25-88,26-64
                13-38,10-53
                31-45,44-75
                1-51,1-52
                69-90,68-88
                12-12,13-13
                14-95,13-89
                51-52,50-87
                32-32,33-77
                46-54,80-95
                28-79,65-78
                22-56,21-57
                51-75,52-75
                49-51,29-90
                14-70,11-70
                2-95,94-96
                36-64,6-36
                22-60,22-61
                68-68,59-68
                1-48,2-2
                5-92,6-69
                5-84,6-85
                15-84,47-93
                13-93,97-98
                30-69,29-70
                87-95,2-75
                53-53,18-54
                93-99,50-93
                40-42,6-41
                10-73,10-10
                1-2,1-98
                55-57,53-57
                26-27,27-27
                72-72,71-94
                13-99,4-77
                37-94,12-93
                41-54,53-55
                23-24,23-63
                28-61,7-29
                3-89,4-88
                58-59,26-58
                3-5,4-94
                13-15,14-63
                10-67,11-78
                57-72,56-70
                2-96,2-97
                9-11,10-80
                80-83,80-82
                97-99,1-98
                24-54,25-33
                19-24,20-29
                1-98,2-97
                13-92,12-92
                74-90,91-91
                26-40,27-38
                51-81,18-81
                37-71,37-38
                7-67,3-4
                88-88,13-88
                9-25,24-93
                90-90,41-90
                41-52,40-86
                2-8,9-92
                6-56,6-56
                18-22,19-78
                29-56,55-99
                20-83,21-84
                21-21,21-67
                17-87,13-19
                64-66,65-86
                32-79,1-73
                13-97,12-86
                91-91,4-92
                43-61,61-61
                10-95,11-99
                3-95,8-96
                6-85,5-7
                2-92,1-93
                59-59,20-59
                14-93,92-94
                19-20,19-52
                47-64,46-51
                3-4,3-95
                5-90,5-91
                66-96,12-74
                39-93,40-95
                3-5,4-96
                39-80,2-40
                8-87,9-87
                12-91,2-12
                79-88,43-88
                29-64,64-64
                17-76,16-75
                14-97,14-15
                88-88,43-89
                40-60,34-40
                16-24,15-16
                16-94,47-89
                32-40,32-80
                93-93,12-94
                23-66,31-66
                60-78,37-39
                38-65,9-65
                28-28,27-29
                24-77,1-10
                14-59,15-95
                15-15,16-81
                83-86,7-83
                6-63,3-63
                54-71,56-70
                43-90,42-44
                7-63,6-44
                44-78,44-77
                63-82,81-81
                31-96,31-97
                27-45,28-34
                47-78,47-48
                90-95,12-95
                23-46,23-46
                1-50,51-81
                23-24,24-24
                4-22,21-44
                10-72,9-22
                66-67,22-67
                1-63,2-33
                62-62,17-61
                34-75,35-42
                30-45,29-44
                2-92,3-94
                50-51,41-51
                31-44,44-45
                7-27,6-73
                34-93,35-94
                23-74,38-74
                24-97,38-99
                9-9,10-73
                35-36,35-99
                67-76,4-75
                95-97,20-96
                69-69,61-70
                21-98,20-20
                96-98,52-97
                49-49,16-49
                11-84,11-12
                34-42,42-43
                53-58,16-56
                24-86,24-24
                29-63,29-29
                21-84,5-80
                94-96,23-95
                11-31,12-30
                54-86,53-85
                16-87,17-88
                9-90,8-10
                12-78,11-77
                11-84,12-85
                26-33,27-40
                63-77,69-95
                40-87,41-88
                5-94,4-6
                40-82,37-51
                44-52,41-51
                52-97,53-99
                57-58,51-58
                13-80,76-79
                58-67,29-67
                59-91,58-59
                49-83,13-75
                6-21,9-85
                86-99,98-99
                11-79,96-97
                3-4,3-97
                21-95,95-97
                84-89,47-86
                29-87,63-89
                5-89,90-92
                27-45,28-44
                53-90,52-91
                7-7,2-7
                51-66,51-51
                45-47,18-46
                37-48,36-38
                9-28,25-28
                55-98,55-99
                35-39,40-99
                31-69,1-69
                43-60,36-60
                16-36,30-35
                65-66,65-80
                12-88,12-12
                53-53,53-63
                17-18,16-18
                30-56,10-30
                7-38,10-46
                1-77,78-78
                6-94,5-78
                5-57,58-60
                49-76,48-75
                26-96,95-96
                45-47,11-46
                55-56,22-56
                29-83,84-84
                51-72,46-52
                67-83,68-87
                76-91,51-91
                25-97,25-26
                3-92,17-92
                55-68,68-69
                39-95,38-96
                1-83,82-83
                7-47,48-67
                45-73,72-73
                9-99,3-55
                81-82,31-82
                5-5,4-32
                14-23,22-87
                48-51,24-50
                23-23,22-46
                50-51,18-50
                17-91,3-17
                31-89,30-88
                11-74,7-12""";
    }

    @Override
    public String exampleRawData() {
        return """
                2-4,6-8
                2-3,4-5
                5-7,7-9
                2-8,3-7
                6-6,4-6
                2-6,4-8
                """;
    }
}
