package kafka;

public class Runner {


    public static void main(String[] args) {
        DynamicFloatProducer dynamicProducer = new DynamicFloatProducer(19.9f);
        DynamicFloatProducer dynamicProducer2 = new DynamicFloatProducer(29.9f);

        FSTProducer fstProducer = new FSTProducer();

        byte[] data = fstProducer.encoder(new float[]{1.1f, 2.2f});

        Object dataOut = fstProducer.decoder(data);

        System.out.println(dataOut);

        try {
            float x;

            while (true) {
                x = (float) Math.random();
                DynamicFloatProducer dynamicFloatProducer = new DynamicFloatProducer(x);
                Thread.sleep(3000);
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
