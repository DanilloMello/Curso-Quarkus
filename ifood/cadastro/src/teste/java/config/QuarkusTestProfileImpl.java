package config;

import io.quarkus.test.junit.QuarkusTestProfile;

import java.util.Set;

public class QuarkusTestProfileImpl implements QuarkusTestProfile {
    @Override
    public Set<String> tags() {
        return QuarkusTestProfile.super.tags();
    }
}
