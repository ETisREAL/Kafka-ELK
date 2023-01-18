package kafka;

import org.nustaq.serialization.FSTConfiguration;

public class FSTProducer {
    private final ThreadLocal<FSTConfiguration> conf = ThreadLocal.withInitial(() -> {
        FSTConfiguration conf = FSTConfiguration.createDefaultConfiguration();
        return conf;
    });

    public byte[] encoder(Object obj) {
        return conf.get().asByteArray(obj);
    }

    public <T> T decoder(byte[] bytes){
        return (T) conf.get().asObject(bytes);
    }
}
