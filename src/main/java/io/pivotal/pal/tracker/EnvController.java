package io.pivotal.pal.tracker;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class EnvController {
    String PORT;
    String MEMORY_LIMIT;
    String CF_INSTANCE_INDEX;
    String CF_INSTANCE_ADDR;

    public EnvController(@Value("${port:NOT SET}") String PORT,
                         @Value("${memory.limit:NOT SET}") String MEMORY_LIMIT,
                         @Value("${cf.instance.index:NOT SET}") String CF_INSTANCE_INDEX,
                         @Value("${cf.instance.addr:NOT SET}") String CF_INSTANCE_ADDR) {
        this.PORT = PORT;
        this.CF_INSTANCE_ADDR = CF_INSTANCE_ADDR;
        this.MEMORY_LIMIT = MEMORY_LIMIT;
        this.CF_INSTANCE_INDEX = CF_INSTANCE_INDEX;
    }

    @GetMapping("/env")
    public Map<String, String> getEnv() {
        HashMap varMap = new HashMap<String, String>();
        varMap.put("PORT", this.PORT);
        varMap.put("MEMORY_LIMIT", this.MEMORY_LIMIT);
        varMap.put("CF_INSTANCE_INDEX", this.CF_INSTANCE_INDEX);
        varMap.put("CF_INSTANCE_ADDR", this.CF_INSTANCE_ADDR);
        return varMap;
    }
}
