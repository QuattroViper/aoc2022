package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DayThree {

    public String process() {

        int total = Arrays
                .stream(rawData().split("\n"))
                .mapToInt(s -> {
                    int sackSize = s.length();
                    String first = s.substring(0, (sackSize / 2));
                    String second = s.substring((sackSize / 2), sackSize);

                    char commonChar = '*';
                    for (Character char1 : first.toCharArray()) {
                        for (Character char2 : second.toCharArray()) {
                            if (char1.equals(char2)) {
                                commonChar = char1;
                                break;
                            }
                        }
                    }

                    if (commonChar == '*') {
                        return 0;
                    }

                    if (Character.isUpperCase(commonChar)) {
                        return ((int) commonChar) - 38;
                    } else {
                        return ((int) commonChar) - 96;
                    }

                })

                .sum();

        return Integer.toString(total);
    }

    public String processMore() {

        String[] lines = rawData().split("\n");

        List<List<String>> groups = new ArrayList<>();

        int counter = 0;
        List<String> group = new ArrayList<>();
        for (String line : lines) {

            if (counter == 3) {
                groups.add(group);
                group = new ArrayList<>();
                counter = 0;
            }
            group.add(line);
            counter++;
        }

        int total = groups.stream().mapToInt(strings -> {

                    String first = strings.get(0);
                    String second = strings.get(1);
                    String thrird = strings.get(2);

                    StringBuilder secondSet = new StringBuilder();


                    for (Character char1 : first.toCharArray()) {
                        for (Character char2 : second.toCharArray()) {
                            if (char1.equals(char2)) {
                                secondSet.append(char1);
                                break;
                            }
                        }
                    }

                    char commonChar = '*';
                    for (Character char1 : secondSet.toString().toCharArray()) {
                        for (Character char2 : thrird.toCharArray()) {
                            if (char1.equals(char2)) {
                                commonChar = char1;
                                break;
                            }
                        }
                    }

                    if (commonChar == '*') {
                        return 0;
                    }

                    if (Character.isUpperCase(commonChar)) {
                        return ((int) commonChar) - 38;
                    } else {
                        return ((int) commonChar) - 96;
                    }

                })
                .sum();

        return Integer.toString(total);
    }

    private String exampleRawData() {
        return """
                vJrwpWtwJgWrhcsFMMfFFhFp
                jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL
                PmmdzqPrVvPwwTWBwg
                wMqvLMZHhHMvwLHjbvcjnnSBnvTQFn
                ttgJtRGJQctTZtZT
                CrZsJsPPZsGzwwsLwLmpwMDw
                EmptyLine""";
    }

    private String rawData() {
        return """
                vJrrdQlGBQWPTBTF
                fcpTMnMqMfTnZpgMfPbFBWzHPpBPzbCPPH
                mcVMfcsqZgmgVcmfgcmZmqZNJhrlrdhNhDdrRRJSvDTRhJlD
                pMFRmLwHMbRPmMbPPddvqqrrNSTFVttdrN
                hgfpgCGZcjpcgfvNtdrtjvrdtSrd
                gZgsBBBlZggBGhsfhpzlzLDLmLRDRMLDPw
                hChhMFCvqtTMwbSSHgTZWHZd
                jjBNPjJJNfsNjVnVJJNcNfPwGbSbDZnZZgHrddwHrrgWGb
                mBBRRmBBQBmNJWhCzqllzhRCCv
                lQgpngNgQvHdSgWwjMRmDjmMDHmm
                zCLVzfzzbbCzsZZPbZPLfFJJMDWWRcDsmJRcjmwTmlRj
                BblftzBtlFznptSQQQppNG
                wJJwqCtCGRcVlqlM
                BQpppjBQLczTrvHRjH
                QQQFnmQWWRfnpQBpQpfDCwCdbPDCwbNNPtdJPCZw
                gpJjshBpgjZGppJqBGJjJZzTwzTmcvzwwcmvwsCFdmcF
                WPSSWWSQLVdDDfWltDWLPfttvFCVmzCCTFnmwcnnnCTCzVVv
                tLldLltDQfflrRWNqBRjgHBpJNZjHj
                bzVJjVnjbCGVLZQLmmsJZZQQ
                RrwwzhPScWSwrhvZZvZlZvvSTsQS
                HwFhzFWdPHfcPwPWPdhWffnngpjtnjgtpnfGCGnG
                CPwQtftDQfPDBPBCfDDDCDptszcpVVddcRczVLVdccRGrLWs
                FqlSnhlqhmhMbHqqSQlHbcrRrsWzRdzdWVzLRGRrVF
                MbQmSnHZhqZMQMTJCttjCgPCwfgDwT
                CCSpvHtZHSwftFtdtbfR
                QJmNPmjjJNgNVNSzDlmRqbWlqWWfcqfWqbwfqR
                MDhJzmSMDmsZrLhssrvh
                ZhznnrLzcHhHSjsjSBSsBnSS
                dTwqDdqDRQjNdwqjldggDvBJfmBfTSBbBSvfSJsmff
                DjCldNglVwFVgZHHHzhCMcLhMC
                vBnShjwwSshmQPmtJLpJtn
                rDLFCWrClWCMWWVrbFVJqpQqpHmtbzJPQzJmzb
                ZMCCDCMNrTWTrgScgGRhsvcsGLSG
                LQpJglQQRjQsppfsQbjfbQlBgBhFhrvghhZCdPZZZthPgv
                zVHDMSWVVMVWDzmnVMHDSMMzZvNFFrFvPCdmdFdNdrBPZhhd
                ncqqSzMVCcGWVSCTWCDcVTffLLLbJsLLsRLblRQTps
                zjGzLQtFzzRgwwLhVrqw
                dfClCdHZsmffZDWlBZHCDBmhJbqTgbwgqbTnwrgrqRbT
                HsdwPCsWDpDsBpfdWdHldWpsGvvccPvGcvzQvFQvccjNztQt
                wmVVgFPrFdwJrlNHQHSHCCHL
                tWBtvnBqZZMpcvmmqMBRCQQLCLWCHfNQQCSGWL
                BBsnmcpqPswFsTws
                BQRpFPJJJJPmPRqZNFVhcczHHzggwjBhghgzHw
                snTsTLtrlvSSSslsGdcwmjhgggvjHhmH
                nSsWWTtCbbDSnlRRZCfFRNZmCVJf
                tRRMCWLtJWQLqLrmLHVLqmqh
                JszPjSbGbsnGnSZprVpFhvFqvhrqZZ
                zgbGSDBbPsTgbDBzzSDnDnPTcWlWJCQlNttNwwwMcMctcW
                hlVRvPvzqqtRdwRRJsst
                HHVNVBMBjHLTjVjwDjsbjJwbdmbbss
                NBZHMCNVCCpgLTWggBpgNLTvqCPnGhQhCCGlqlhfcvvGfn
                mwbfbfbDCqRJZRbCSvmfWTQFczTznnnFTFnrzJsz
                BdhHlLjpjjjncSprnsSFWS
                ljhVBPjSdHPRfZRZDvVRZM
                tGqbqBSsntRgNqwNNVVHVN
                hclFvJZvCDFppDpZpHNggMTwdlrMQNVgHM
                CCFmcZLDFpvzZhCFJvZvmwjSRWsBLWsnfWjRRGGfnsst
                GdGQQFdcMPwMdLFvWsNWFDLfss
                SqjhtjnrbVznSztSqtzpjztVvTmNNmmfMMfDDMDDNTqfgsqv
                rVhhZjppVrhpVzRbjSnzHPMwlJCJQdcRPPlPPcHJ
                JVQLVgVZghFtFlhghtvSzsddmrdvssmzSWtd
                HTMJCBMCjnwNBnCbTNwMdWfzvzsrsvffWbdsmfPr
                BGnnpDnTjjHJwDBNpqlFQVQFQclcRFQqpR
                BRhbrQDttbTTtRDtTRRzLHWZLZHGSqWLCBNWqLNL
                fwFPPSjmsmJGLsNH
                dvfSdvfVMjPTttTzczgTcd
                dZgggwzgvsggtdstZTZgdfnhSJSSJDDhnDBdppnGnhSp
                VQWRQWVCRLFGnThJCpFJ
                LbmmbQVcHcmmlWjmVlVQNVRzvwwZvTrsrNwNwzZrMvfsqt
                lDZQSlHDbLccRPQhCNhG
                gtsntgvdvBvvqgsTgBggdrWRNzPhWczPbWcdWCccGGGP
                sTBttvrFnnMTMJngbqfLlZLpwFVljwppZZDl
                zNNNgqpgmLgqlHBHsMGslH
                WdWFrFwhcwWRwhddcRWcdQbcDDslzBDszsHbGBDfbHfzVlVl
                ZvhRrvPQwvWFQRZvFdJttSPgCmNppCNzJnJS
                fCzRRNGfqNRvwpQhwrGcwZZT
                gJnStgMmLhdHndSSTjcTrTpcmrjjcrrw
                FFJBbdddFPPhFFNWCF
                btrHRSBBSNLLRPLwhbhpqpfWhQppWZ
                zCzTvvmgDvgDZhqWZZthtDZh
                ttTjMsvCgRRLRSsBRG
                LsSFFTTDWdCsmFTlLSsLDDRRQCvhpRQGNGQBJBhGGMNB
                zqPtqZnjPPrPvJHBMHrJrMpv
                VbqfjZfwgtfjPgZPgtwDLTLcTlcFdWLdcdVTJF
                pfMCDmpHbdMQQdQFFG
                gdjldRsVFRntQnqR
                rlJVsWgWPWjsslSpDbScmSDPHfCd
                lnFFGgBFBslDFGbFSjnNTjjppSrQHhnT
                zcvmCRcvZmcZzWpTQhQrrTSPtHWH
                CRccrZJmdJlwDJwgswGg
                hllrrDzggGppgSSLNWgW
                jlTlPwwqjjntVpWWPNnP
                wjjJqvQjJjQJbTjlFqhBMzfDDmMCGBMHDCGb
                jvQPhhtCRtfmqHHjqHHJsl
                FFSTcBTBTMwFGCTwMTcGwTVnsHSJzqqJJJplmlpJHszZZzZD
                dLMdVMNGBdGFMTNTRRLrQWCQhgWQbhgf
                gdRgdgzzrvrzggDwgDGpPLzrbNljMTsbWWjWjZbTjLZMWcWj
                tFfCQHJJnJMJTJjNNMjl
                HmtffVttqHQmBCBQCqfFnCwRqpDvPRrGppRggNzdwgzp
                DHSqzQbzWlRLDzMZNpVLgnpNLggw
                cZcdTmPPthPdsvvdhPGTvJgwnpgjjTgNNwMVngNBjNfn
                PPdJPvrtGtcFdFFchDRHDqHzZWSQQCrQWQ
                BcgnLBLsFvRnGRRRlzfJbbPJzwHPwPFz
                hCDjWMDVNfVllfzddw
                qqMqpWCMjDTWNWTBLpgsgLvZwtGLLg
                zczPgpGzhnbmbchhHwqwhSwfwHCFWw
                VJdmVLlLdVJSJWHSTFwH
                rlttQLVLdvvZpgcGbmDrzGMD
                WSvtpqqtqccttVQpVvJNJSVNCmTlnCWwTTnWlBBBjwCBTlTP
                ZgfPHfPfMHsDCwnlGBwTMGBM
                rgdffZhPrrLsdLZpvcFSJJNvpJhcJv
                qVdqJGvzgJzJgwzgWvdJzpblcRRWmLFFcLBmllFRRMRFRH
                TGGSsSssNPTSLlRLcPHMmnPB
                tTjTZtNGhrCjQNCjQQDTCSjZvfJbdgqrdpwqfVzwgzvdvVgb
                VTmwcTVSMHwbMwbDVBTcMpJfpfnWqdJbZpJldfsjZn
                hNtPhtzFzPQGCCGFFCGtnqQqWZWplsjWdlnlldJn
                vRCRzvvFFFvhrRthPtLrtNGSwBVDScDSgHHjwwcBgSgTSL
                dWCsWbWWchblsmbWVZqqsSpsGfBqBVBB
                DtTtjPJrgjjtTTwgPwwjrTgnLqSBZQLqngQppqnfBVQfGp
                PJPwwtDwHGGJtJRFHmhCFRCvdmHR
                mMsMJSCjllsSSmBBclsMsJHDbcHqqbHpqHGbDZHbqHpb
                RnQnGVnzGzFQgzWzpzvpqDHW
                QVhRTfGLLFGTTFFwhnQVNfFwJsJsMjsBMrlsjrJlPSPlTrls
                JNMJSVSGVCjnWZMZWWcH
                gLTcqbqhqbbgzgnjpnjjWHnP
                wqlbcrfTwrvcLBwwRtJwsNRstRsCCN
                MlBssQBchZDLNJZgmvGg
                fdzHMfHSzSprfgSvvJbmvDGNDW
                PCHTRfjHnzHMzzfrCPCpMTlFhcFstqVwVCFllQcBtqss
                TtFnnFJfDhtdfJJcFtfnsfcFjBjLDjHrDLrCjMjwCLLrZjrS
                qQmWmQzvWpRQGvgpGGRGRzmWwZMwBLCHMZjbBBCLwrHSLrqr
                MRllgRWWMlsJFnlFclJT
                SRRrRDRBRTdbdMRZBZMprTCJCnWGvChJGzLSWWzsGhCs
                wwqHPtFwjwTHLHvGTsGW
                FlPtqTNVcTVtwtmjRbBZfQbfZbQmRRMR
                WSWfQttffsHSfRRRStfnCsQQqlJpbhnrnmNzJbzqNbbrpmnb
                FGFPddBcBwDPzpzbWlpzDbbh
                ZPdPPLMFdGwFFGdwGdZwcZgTtSTVCsRRSgSRTQWTTtCTtH
                vHsfGHTvSvHHHsGHctMgtHrJwbJJwrjgbrdzjWCrdrrw
                hqZRLmmZpFhcLhFmrzJQbzzmQQJWJJbm
                LNZFcpPlhBRhqDDllRtnMssGfBsnttGTnttT
                VDVrLrZZcjrhhFrZppGlglGMPFwFWNQw
                bzszSBHBWNGcscpN
                TJqBqSfTBBqBHzJqddBqzcLnLjnhCRTvvRrnDrvrvZRn
                GLzrNWbtMptHDmNDglgmlD
                fZtcfCRvtBcQjdjgmmjj
                RhBhhqfSPPpttrnPnVVW
                BhVRJGwWqtHjZqTDLZ
                gQnfpBdPNpQrPNSfBdndnpTTDFZttDLLzZzTzCLNLZZD
                mQQPsgrldpgdBQgSbGVcmcRwGMWhwVwW
                DrLCctBCLQtSSQcLbcQHWvvvlWHHnWlWBlNRRB
                wqdmpgqsZhzGphwwpZGsppRvfnJsWfHWvfFfWFsfvlNN
                mwmhVppTqpGqpNZpqTbSLLttDrDDtPQTtr
                qwqmgnglDnlgtQzQJzJQhmWQ
                pTpTpssdsVvNsdTSZGdSdjvCRcqcRcVWVczhWChtchzWcR
                sGTvPqZvSGdZZGdsvNGdPHrFHFBDlDLwPgBFLLBB
                BBBGsGGBrBBrqWVqRnWBBBWpzFwMhjMFSFPzzSwPFPpzzFvg
                HtCdDdDctZDtbHCffcbddbNfvjvFSPFjMhMgLwPgjbFhjFFj
                NJTDdltNgCNDZJJZCDJZDfJtrWWnQGBqlRVVlrBsnlrqqmnr
                PwZhgbZSWSqqGznv
                tTPVVmptcsrNrsTNpjRzqfHvvGfGWjfjqGzHWn
                RVRtVDRmsRtrctmJDtgBBhBhbFgJPFFMFJgP
                jPzzCCPzTtTfzrRtgSNVRHvFQVvbpQppVN
                sSnDlBGBwJbFNplVlN
                cLwSwdMhSwcBcsBZgWjCTCWfCLffrg
                RSNPvTTNqFTSvNrSBvBGJGzmFMslgCMJCgmzlc
                fDVfpptLWQfnVLffVHbQDQCclJzGGCtGmmGJmzMshzGh
                VfQnWZfZDbdnVHWcfWnfHWVvPrTSNZqSwSqPjjvBwRqrNS
                FLRpmRwcpjfzjSnD
                tGvPNvBnPQggPQQvPgNHDjSSjDzzthjzfHrjlT
                JGqvWNCCGQBWGBQvVLsCMMRLRnRMnwMc
                fGJbzgBffCGpPGDVnG
                mcTccshvbbdRNRsNjdLjnVlHVnHLqVpDpDqD
                wdmsWvWssbZTcWvRhfzMQtrzMgrfrZJgfQ
                NfSbvZHZNRSbQbbQgZrMjhLwMrjLjwHLCmmh
                NTWdJBFcWJFcdsFJqcqPwqmjpMrLCMpLMwLP
                dNJctnFBVfSGgvnfZz
                GSnRJfGfRJgMDMGWnfzdmptpFJppLvwLwvLt
                hbjZzrQbblqcLtpwlHvFplTH
                qrzqbschrQCqqjPcCVcCGDfGMWDgWNGDDSfgnf
                vmMpCdTndCvMdmnFcCRJWBJGcZJRJB
                NDNwGzshPLrwVVNsjswhGzjFSfFFQQRSJWRBFcFRfsWFQB
                NwNhNjVzhhzzrgzdqqvqtnqvlqdggG
                MdPLVSSlMMVMmlLBBLFdvZNWqWztStttRRNqzqNGTq
                DhJfhghhCgwChJgJwHHzbsHpnZRtTWqqfZRGTnWTZtNqNRWR
                hwHpJbprwpQhDHDCbCCzsClBvrLMVFPvmPlMMVMdLrvj
                DssDrqRsWsNfzfsWLRzjgTdBlgzFpMlgTFTglT
                ttCZnSQmSQmgjGQGQgDlBp
                bhDnCmbwVmCwwtZttPwbRWsRJcqWJfcfsfrqVrqq
                ldBgTMTRvBDVnCCCTdSRTqNjbjSbPPPPqtfPqtPJFJ
                cZHZrszLrrrZHrbNjNtbJCfqNJLt
                GZzCzWZGGsGzmzZcmGssZzZVvnVdBDddRRDnVlWgRTDdBM
                RjNrrjwGDDqqGJsHtzpMHHGz
                QCbWgbShmBCCPClmmWFHzJzTbDdsMJsTtpTD
                fffQfnSCWDBfhCDLRrNrwcrqVqwNqn
                zmRrDRzqjmLLHzDjLsHLflJlVVJlWWTDTfdMtlWJ
                pPQQnbvSpvNbgfgfVtMVJfgdtG
                SnpnVFcPnNnPvpNSFNSbhHLhrjhCqRsRBRrHCLhzmC
                CZZzlnCZNlGGcbVrbtVlMtct
                MgFQDFgQRLLHhJgDFqQJQLgdtVTrttSrPSmcbmTtvSqvVSTV
                hFQDDfMDfLgHwWfBzWwwsZGW
                bHVDdHVHTPMvnSQnWSDQgDmm
                GhrCJfbfrhfbRJcqGqlwZtnBRtBWSQgQWWnWQW
                lfcCrqJhlfFqphpplNCrNVMPMPLbsLPLzFVHVLsVdz
                VDhFCZhtFdPqwwcp
                SvnvHNNnTvbwNNgnHwTHgwBTLcdqmmfmqLGmmTRLPfpdGP
                BNWsHJgSnwgMMgMBBWMDVJjtjZrDJZzztJhjQr
                HDsSHLRnpjbpbbRDbqLjLjjGGVffMVGMdvnfMcNvfBBGcB
                TCzQQztwwNTMqMdBVv
                hCQWmtCzZthPPZPrLjSbJqjSjLLFjLpr
                ZrrZqJDcZSCFLLHBFcjjHF
                TgvnDTlTtQwgBfwwwzLjGLdF
                VbnVngMtvDTTVMQDQMDQlsbZJChCmCPhprrZqhqZSZPJ
                glMGHBJTJJTplgwcCgcqcFhhbWncFm
                sSswtPfRDmWcCqfchq
                RZSdSzsVzNPSwSSQsdzSSQpGLjJTMpBGrJrLLrplZBpG
                WQqqwLqQlnlWDwtbVbtCNfVbpV
                dFTRjBPhcBgBrFhTPhrbVptJpNNbbtJCbJSL
                hjcmcRmgPPcRcPDmHHzGLWmsDmzH
                rWFmrRmmccSZJWvSLZTH
                hDPhGbhSjtbpqJLvJHjLHTqj
                pnplBlfBPPhlgfDbDhglPMMrwrRRSSncwccQzddzmC
                LbccJCGzbcCJcfGczcnmNnvNmZNLSDZZWPWS
                dwstRhTsrsFddPZqvNWP
                BBggRrQstBwBRTHWTprRCHHGVljfCGCfcljHjbGV
                FHVBSVDvnsFDwwSVwwvGVSMFWhWcWptMWchWMtPPcWtNNWcj
                TgqJrJTRmRCNrbcLjprLnp
                qQTlfdlZQgmfqqnFVznvQwvnsBsV
                TGpDDMQGMZNtfvDJdtWd
                jbrmstmllRmNvVhmmvJVhv
                tbrRzFFLlRrjFlLlTQgLQwwLMwgTZBTB
                QFgFWQQfSgLFGmtnnVmqCPWmPH
                TTzjgTbRRqnRsCPCsP
                NDMMgZjzcJvbjhMcjZbbbJJNpdpBfBvSBBQwBSQLQSpSplBG
                zcRNsQSSMjRsNNZZFBLQHHFFBPWF
                tvwCtgvqLJNnNBCH
                fNNwqrqNMpTrDlcs
                MMHMVPRJHJWvqzWctbtQQdQz
                DFfNFffDnTllfTfFfmzsjqcdtQGQpbddQQbssn
                mlFNCgFNNNLrmLFCThhhzJBvhSJPVhMgMh
                PWjhljbHFhjbFMWhjbPfhbTGZvlGcGlCLvvwtGCNZGvc
                SRqBqBrmQWQrgQrrqrJBLZNccLNZmTCtvTGtCvCt
                rJDzDSSBrzdqQWDPHFMjMFdjHMVnbM
                qqLwvvtrLFqqfqrjjjdBZfBCBBJdlT
                ZGZpRZHbQDzDWRRRVdBzSSlBdzjjzdJJ
                ZGpgNDQmWGDRmRpZMQbvPPtnnFnLsstFmnFrPL
                TdhcfZhdZZdpdbPWttCWrrCN
                MBMMqRLgpGpFFWbNsvLwvCPCCP
                mpBMnBRMBGqJfZcfZZHZlhfm
                CdmGdnMcMwHjhDtFFnrj
                vPbVbPBPPpgpgWJpvTjqDZZqSHqVZShrDj
                BppjjgvbJjbpNbzPfNcGCLlCRcmLLflllGcc
                qDtgVttGFtlslStS
                gCZbbHCjvJbZjCbJhHhHJrZcslJcLzLllcLNFssMSsTlSM
                CWbWrZgWBQQBBpfdPm
                hstPtCGtltlTClllPJLScVdPdJjLPJMV
                NHRbDZDQSDFFjjdJ
                RqbQpgBmqZvqZNQqgZmmbszpTtthtCswhjslwwpTWC
                CVdwBJJdppbbwdBVrJbrJbGPlMFSLrjrPjmPFFmPRRDF
                NNWHHhNZTcQWhnNFlmSSlRmLjnPPRF
                qWsccHTZccsNsZcvTcNtStpBtbdVwpfBwbVCBq
                lPQHNJhMPMPFlNMHBqZBwQwQwQZwcCqw
                bWddDzbWbftdDSDbgttgnSDWccLwcvBczqcqGZzLccZTZwwc
                spWrssWrnDtDpfSWDtsFqlFPjNMjRJVVNNPJNp
                bCCfcWVLTHfSSdHwhH
                sGQSZSzQJmmQsphwHHHsndnpHN
                zPSqrmZPFCvFTbWMLV
                tLtVBGLJqGqVGbzGSCsSsSqQsFvZCSQv
                gRgdWlHTBHgjjHlWpWjWjrwdCfQRZFSssQQQZmQmMSvZfFMQ
                lPHlpWgjTldprNWHNNdHjTctcLbVcnNJJGbVzBhnbhhJ
                zVrSwzzJbVrbqFCVVVwVCztWDDtfTZsWDZTLZZmSWsDm
                bpgHlgBbbGGGglBGRNvMpWfTDjmDfWDjfRZZWLtmZs
                bGbvQHMpQccFJPPh
                VGqCPmPjfGqCdMqVMhjhmPChDJDJzvrrbrBvrdrpnJDpJDQr
                TSRsgHRSFHTlHvJvBDvvzlptbv
                ZFLTsRRgZTgWscHTfWNWNPPBfGqmmMfV
                TvTrrrCVCVwqjPrWfWhjfH
                RRmgmnggltRgNpzRsdfqWWjdFdvNHfdh
                zZlRzDGGZmbmmZbvGJVccwCMVcVVTLwDwC
                QPsNlvvvSccbbNQcSPvDVSvzTLLCgRVzCJgTJpgCpphgzh
                MDqHwFrMffgFpgpJLzTz
                ZtdrffBrdqmBBmfwMtDtQPPPbjcNvnllnlbNtScn
                HbbbcpTHHMMqNTCddCVBQvgPzJPJWQBQjvpBvQ
                FFrDGtntFFwhrRFDFthfRhRmSJPJvvJZjZjWJJvJQJnvWjjg
                rtfFfLmLRmNgdHqcLNHd
                FpFHCFWtFSnCWnBfJJfgMJDGHDGGsG
                rhrLrrhLrbtZThLfgsfGNDfgTgNcDs
                QmPjbdqjmbbbrmhQqQZrZStRdlnnFdlRzVVVWlnpzR
                bBMwwjzhbjhssvsGZBSZLr
                JFtnDtRzJtffJHWNtHncRRrvGZvSnllZZZsgvlnvVvlv
                RRPHPHFPHHdcHtzNfMQhdCwbqCmbMChhqq
                pWGdFSWwwjLdvgNNvggl
                mTNbmRPHmmVNmvZhnhBssBlhnb
                HPTzRPffJJNzjCFpDWDz
                MHlgzsqHlbmzgsHzlsbcRWPdPtjZFqhGGdrPrjPJGrVP
                vpwwvQwCnhNQpSnLdVtrrZGZtZjdVSdJ
                hfffwvTpvLwDpCLvDnQDHbmRRTcWRHMWWHWMmWMW
                WHlNHWWldjpwntnWBPpPQFZFBFhZBZCZ
                TqqvgvmgfmvDVLLfqqLsrFBRhrrBFJQBGPgPZGCR
                mcDbcDmzLcmDDzfVzTQNjNzNztdzjNdwSHlH
                EmptyLine""";
    }
}
