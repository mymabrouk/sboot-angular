package com.authentication.service;


import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.JWSAlgorithm;
import com.nimbusds.jose.JWSHeader;
import com.nimbusds.jose.JWSSigner;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Path("login")
public class AuthenticationService {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response login(User user) throws NoSuchAlgorithmException, UnsupportedEncodingException {

        Map<String,String> authFeedback = new HashMap<String,String>();


        final String sharedSecret = "a0a2abd8-6162-41c3-83d6-1cf559b46afc";
        JWSSigner signer = new MACSigner(sharedSecret.getBytes());

        // Prepare JWT with claims set
        JWTClaimsSet claimsSet = new JWTClaimsSet();
        claimsSet.setSubject("mym");
        claimsSet.setIssuer("http://microservices.io");
        claimsSet.setExpirationTime(new Date(new Date().getTime() + 60 * 1000));

        SignedJWT signedJWT = new SignedJWT(new JWSHeader(JWSAlgorithm.HS256), claimsSet);

        // Apply the HMAC protection
        try {
            signedJWT.sign(signer);
        } catch (JOSEException e) {
            e.printStackTrace();
        }

        String token = signedJWT.serialize();
        authFeedback.put("token", token);
        authFeedback.put("user", user.getUsername());
        return  Response.ok(authFeedback).build();
    }


}
