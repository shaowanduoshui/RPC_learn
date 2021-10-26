package com.example.rpcprotocol.serialization;

/**
 * @author Yancy.wu
 * @date 2021/10/25
 */
public class SerializationException extends RuntimeException {

    private static final long serialVersionUID = 3365624081242234230L;

    public SerializationException() {
        super();
    }

    public SerializationException(String msg) {
        super(msg);
    }

    public SerializationException(String msg, Throwable cause) {
        super(msg, cause);
    }

    public SerializationException(Throwable cause) {
        super(cause);
    }
}
