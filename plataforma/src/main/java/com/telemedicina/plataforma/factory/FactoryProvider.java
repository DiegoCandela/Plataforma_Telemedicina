package com.telemedicina.plataforma.factory;

public class FactoryProvider {

    public static AbstractMedicalFactory getFactory(String tipoUsuario) {

        if (tipoUsuario.equalsIgnoreCase("MEDICO")) {
            return new MedicoMedicalFactory();
        }

        if (tipoUsuario.equalsIgnoreCase("PACIENTE")) {
            return new PacienteMedicalFactory();
        }

        throw new IllegalArgumentException("Tipo de usuario no soportado");
    }
}