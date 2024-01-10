import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class study {

    public static void main(String[] args) throws Exception {
        List<TestDto> list = new ArrayList<>();
        for(int i = 0; i < 10; i++){
            TestDto testDto = new TestDto();
            testDto.setData1("data1" + i);
            testDto.setData2("data2" + i);
            list.add(testDto);
        }

        Stream<TestDto> listStream = list.stream();
        //String data = listStream.map(TestDto::getData1).filter(c->c.equals("data110")).collect(Collectors.toList()).get(0);
        //String data1 = Optional.of(data).orElseThrow(() -> new Exception());

        //System.out.println(data1);



        HashMap<String, Integer> hm1 = new HashMap<>();
        hm1.put("A", 100);
        hm1.put("B", 200);
        hm1.put("C", 300);

        HashMap<String, Integer> hm2 = new HashMap<>();
        hm2.put("C", 500);
        hm2.put("D", 200);
        hm2.put("E", 300);

        System.out.println("[합치기 전]");
        System.out.println("hm1: " + hm1);
        System.out.println("hm2: " + hm2);

        Map<String, Integer> hm3 = Stream.of(hm1, hm2)
                .flatMap(m -> m.entrySet().stream())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) ->  oldValue + newValue));

        System.out.println("\n[합친 후]");
        System.out.println("hm1: " + hm1);
        System.out.println("hm2: " + hm2);
        System.out.println("hm3: " + hm3);

        System.out.println("리베이스 테스트 한번더.......");
        System.out.println("dev02에서 추가.");
    }
}


class TestDto{
    private String data1;
    private String data2;

    public String getData1() {
        return data1;
    }

    public void setData1(String data1) {
        this.data1 = data1;
    }

    public String getData2() {
        return data2;
    }

    public void setData2(String data2) {
        this.data2 = data2;
    }
}
