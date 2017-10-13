package com.authentication.service;

import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.JWSVerifier;
import com.nimbusds.jose.crypto.MACVerifier;
import com.nimbusds.jwt.SignedJWT;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.text.ParseException;
import java.util.Date;

@Path("validate")
public class ValidationService {

    @POST
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.TEXT_PLAIN)
    public Response validateToken(String token) throws ParseException, JOSEException {

        SignedJWT signedJWT = SignedJWT.parse(token);
        JWSVerifier verifier = new MACVerifier("a0a2abd8-6162-41c3-83d6-1cf559b46afc");

        boolean validation = signedJWT.verify(verifier) &&
                ("mym".equals(signedJWT.getJWTClaimsSet().getSubject())) &&
                ("http://microservices.io".equals(signedJWT.getJWTClaimsSet().getIssuer())) &&
                (new Date().before(signedJWT.getJWTClaimsSet().getExpirationTime()));


        return Response.ok(validation).build();
    }
}
