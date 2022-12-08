package org.example;

import org.example.Day;

public class DaySix implements Day {
    @Override
    public String getData() {
        return rawData();
    }

    @Override
    public String process() {

        String dataBuffer = getData();
        for (int i = 0; i <dataBuffer.length()-4;i++) {
            String possibleStartCharacter = dataBuffer.substring(i, i+4);
            boolean isUnique = possibleStartCharacter.chars().distinct().count() == 4;
            if (isUnique) {
                return String.valueOf(i+4);
            }
        }

        return "Non found";
    }

    @Override
    public String processMore() {
        String dataBuffer = getData();
        for (int i = 0; i <dataBuffer.length()-4;i++) {
            String possibleStartCharacter = dataBuffer.substring(i, i+14);
            boolean isUnique = possibleStartCharacter.chars().distinct().count() == 14;
            if (isUnique) {
                return String.valueOf(i+14);
            }
        }

        return "Non found";
    }

    @Override
    public String rawData() {
        return """
                rqwqtwwrmrqqrcrtrpppjrjgrgjgqgttgbbhppftpfpdpmpsstffqvfqvvdjjpllltqltqtrrzlllbldbdsdqqgpqggzccgbgnnmjmljmljldjldjjlnnhndhdmmslmslmlhmmntnrtnrnbrbqrqhqfftwftfsfzfcfrrzllchcwwtwstwwjwrjjfwwgzwzqzpzhzqhqbhqhssltsszhsszdssrwssdppjcpjjrwjwnwjnnzjjhsjhsjsjvvtffffqfflglwglgbgpbgbgghfghfhdfhdfhfssqppvlvslltwwhwvwpwgggnpnnmqnntqnnlhhdbhdbbtvvcrrcgrrdrvrjvvlmlnmndnmnrncnznsnsqnsswrwzwmwzzbpbhphqhpqpbpqpjpjvpvwpvwppdvdhdccqbccfncctrcrjcjjdsdhdnhhwpwlwwbmbhmbhhpzhhccvffqqnsqqmnnspnnpfpzppspgsppgbbdwbbdcchfhgfhfllljtllnjlnlddvcdvdqvvqwqppprtpthtthqqfbqqpfpzfpfcfsscrsccbgbngbbgdbbpgpqqlmqlmmgffqqqsbqbtblbwbqqvbqvbqvvnzvzpvvqhvqqtltptllbflbflbflltddlblflvfvbffmsffhlhshmmgbbgjjdndqqmqllzjzvvhjhnhcnchhznnhhppwqpwpffwvwzzppwpfwftwtnnqbnqnrnrzznffzzblzlvzlzrrszscsqcssbggcgvvddsttgqqgwgcclzzszddlvddvbddrlrcllrblrrhlldzdtdccqllsblsszlszzdllhjljhhhzhffdwfdwfddwdtdrtdtntddldsllqffdvdhdpdhdrdprprrhggdqgghggmwgmghhchlhmllrnrdrcrqccbqqfbqbccjpjhhvppcwpwffmmzzfqflfjfdfbfqqtmthmttwftwwpmpzplzzpvvgppsbpbccbtcbcddzbzwwmsscrcctgtgjgtjthhjzzcqqmmmvccwjcwjwzzwnnwgwtgwwbsbvbccrscccnggfjfwfjfrfsfddncdncndnqqwzzmssbdsbswswdddpdqdbddcvcmmwwssrtrrlddndmdtmtdmttwwmsmffwqwvwbwhbbqfqqgcqcmctctntjntnbnrbrmbbqtqccqbcbvbnbqnnghgbbmfmwmdwmdmpmwppdwpdwwnzwnwrnwrnntqnttcmcqqbrqrttsjtstcscpcspsnswsggrhggjrjjbhhbnbmmdlmddtqdtdrdwwjvjgjjdhjdddbwwsfflppbwbcbpbjjzqznnrwnnvmvjvwvqqrlljgjmjjqhjhwjhwjjsvsnvvlwlqqjpjjbsjjcddtfthffrqfrqrfqfrfllfzzqllztltnltntpttqmmgwmwwwjjdrjrzrlrwlwzzzzphpphvphvphvpvdvfdflljgglrlrqlrrfpfqpqnpqpmmblbflbfbpfpwpjwpjpbjpjmjljblldbllnrnjjjljrlrcrrgzgbbzrznzzhnzhhtmhmqhmqqnzzvfzvzfftjftfvvpmvppwzzhnzhzvvwzwwqcwctwwgrrtgglgngsgvgwvwpvpbbrvrvwrvwvbwwpsprrrcbbpqppfjjjqnjndnmddvsvlslmmwwdwcchmmrjmjwwsrwrhwwpcgmpmvbdmlmqbnblbbgtmtgqslnvcnmwrflrnwhqzrsnwhncwdvbcpjrqsscwzrjvslhscpvmqjnltwhshjmbhgttbzllrvpnhgdmwtddbwmpgbhrndpgwzfvqdmpcvhlnjnqbwqmshgwhmfjgsbscsjtfbfvmlljqwwjtnltbzjpcqdfmdldvmsnmzqmghcvhlpjzzszcpvldrflbcppzwgppfpbslplrqwgbfwpwbtbnrmbrrrpqndzvhmlhvtlnjvhdrhhvmwzjntsgffjsdpdlhnlslnbmbsmdsvpmpbjpjcwhbpfnhbmttfglglnnhhcqvbpvnrwcszwjsdhqwctrpgsrcbfpzhbnrbllrlflqdlgzwpwgwwvmbsppbcjcdltbgwfndqjlvndhtclfmwnqrbfvvqdzspfcslplhtmsqqtrcdvbhfscvnmzplcglwnzbvgflclclqmdgfzjqqrrmpcqrzgqcnzbmncmvdzrmmvfqrrqzqbjmjgjwmfbnmmgvmzsgjjspjqbvfhrdvllgqsffjnfqdthjbjwhwqdqhsnctwgbszvrsbwbpptcjjvftnhdmwmhtjrjrlrdrqjznhqftgtldnpbrlprjmplmwdbzqpmwwvcqccjlhqbhcjprvrfmmfmljwmbrlhcglthgbmrfmbpsztfcglpzlfbpjhmvcmvrprmvmrvvgbbllzschwshhfbnmgwrbhlqvsdjdmmbtjzthwssghtqvhtqcswdhbwhphhsrwhwwtslwvrhpgqfmftnrtqpwfqqdgftdlqfndjlzhvlrthnqdqrzpprdgwwqlplrmqtdqgbdntmjcjhlbbmctvnnhtppfbjpsbmndbdplqlfqfhzqvtqcvmprwbhdtjrqrqvmcssqnfqwtchmjfjlpwsghplbthdnbhfbhhphdmlmtjcvmzjbnqbfldrvlmjfnnrlsnwrtnrpfqdhchltmbvjzhgjwzblqdthmffztqvzzfszmdqdzlfpbfgjfdjqscrhvjflbllnlghncczrlpcbwpnmzcnqhbfnlmnbqvmwvbchwhlfcssctsdcwmtfdgbhljwprfncdgwlgzzmvfqrdsmlwbrmbmtzqqdqdpzvtbstscglrwdpndnstrhgjchnpzsvcjngmzsddwsbllpvqqzzjlmsbncbndqmqphzqzcngjzpfnjmsvngtcvhhjsssrnhjrsmvbsrdjcrppvgsqbqjzbrhjqlgmqfclbrdhwwjdlsjnmjcjrmsstngswrhmdqthprcbrndfpdjgpqtfmmfvbztqdhzhzbzhjjpfgnvrmspdvmhfvbvztmlrhfqfdcfnzzndlfldpfhrbjrwlwnprdmqjwppbrdjhpbvnrvjlrbwdwttzhqqgcclbwghbgrhcvwjrrchqgzztrjgrltcpdscjdfcphndfzdqsbpsjrljdnflfvrzcrjflddfgpvnpmdqbhzwbfrpzsnpbcbgfchvvmqpnfpvvdvhfnpbfzwmbnlpqzgrpwtsjbpzdrsfmnfqwqvpgnrjhmvmphlfdpfhdjljlzftdzdvhjrvjdctwfrctglwmrtdlrvmhcqvfvpgmstghczmvclptzspdsrlvrgvjtvflhsmqswdpqjrrnhgrggzmcpqsctqbhpqrsbstwzgzghqgltcpbrhbcdqlhfjhlcrnhrpjdzlzqqprvzntbjztqgdqqttmbpbcfbjmdjqsflbczmfnsjdzcnnmjjllhvwbwlgrlpvbffwjvctwnrsfqdnwntscpsjnshhdmcqmcpscrmzltldwlmfnbhbtprsgtsbvzfrsfpvmqjzjqqhwdjjzvbhrvtbscrcpzrqsbgfbpwqfmbsrlhhtntjmtrtlwqsdbmgtdlrwfdnmwwzlltbrjgghbstbnffzmzzdlcdgvmrzsjnqjvczmhrgwbrblrqfmzbbcnfsbfpgjsmptzbclfdnwfgbzlpbgqrdhdmfjdnlzczdpvtbzdmrthslngbrldllfcjplhglmwsfpqjnrgpgqfmbbwchbrqqsncfwnmgdmtchdhlzzqjvtvtvgqbtwvwpsjqwdqhrlfmdgdzchvfbcmqjllpjtnphwqvfwpcjmzqhsbwlcmbsgththrsjtnzlsrcptgtrfcwptbstcsdzbwjljzjztzbqsjdvwglpbpgdjtthjjmsnljltglqcszbzqmblfpncntjzzhmjffldcrcvjjswvzlfffrmsgjtpzggtlpfwpwbmhmggpnmzwrgdjrhglnhfdcjdfjtdjvrnlgqtfqmpgjcvcmnwhhbczwwntfbmgssglngqlttfpcznswvmbprsrzljtlwlljnbbrnwdvvlsbdv""";
    }

    @Override
    public String exampleRawData() {
        return """
                nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg""";
    }
}
