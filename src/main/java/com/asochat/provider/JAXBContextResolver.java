package com.asochat.provider;

import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.PropertyException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.Validator;
import javax.xml.bind.helpers.DefaultValidationEventHandler;
/*
 * https://edgegram.hatenablog.jp/entry/2015/11/25/160433
 */
@Provider
public class JAXBContextResolver implements ContextResolver<JAXBContext> {
    private final static String ENTITY_PACKAGE = "package.goes.here";
    private final static JAXBContext context;
    static {
        context = new JAXBContextAdapter();
    }

    public JAXBContext getContext(final Class<?> type) {
        try {
            if (type.getPackage().getName().contains(ENTITY_PACKAGE)) {
                return context;
            }
        } catch (final Exception ex) {
            // trap, just return null
        }
        return null;
    }

    public static final class JAXBContextAdapter extends JAXBContext {
        // private final JAXBContext context;

        @Override
        public Marshaller createMarshaller() {
            Marshaller marshaller = null;
            try {
                marshaller = context.createMarshaller();
                marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            } catch (final PropertyException pe) {
                return marshaller;
            } catch (final JAXBException jbe) {
                return null;
            }
            return marshaller;
        }

        @Override
        public Unmarshaller createUnmarshaller() throws JAXBException {
            final Unmarshaller unmarshaller = context.createUnmarshaller();
            unmarshaller.setEventHandler(new DefaultValidationEventHandler());
            return unmarshaller;
        }

        @Override
        public Validator createValidator() throws JAXBException {
            return context.createValidator();
        }
    }
}