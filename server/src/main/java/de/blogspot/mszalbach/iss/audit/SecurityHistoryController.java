package de.blogspot.mszalbach.iss.audit;

import de.blogspot.mszalbach.iss.domain.Security;
import de.blogspot.mszalbach.iss.domain.SecurityHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.BasePathAwareController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * Provides History via Rest.
 */
@BasePathAwareController
public class SecurityHistoryController {

    private final SecurityHistoryService historyService;


    @Autowired
    public SecurityHistoryController(SecurityHistoryService historyService) {
        this.historyService = historyService;
    }


    @GetMapping(path = "/securities/history")
    public ResponseEntity<List> getHistory() {
        return ResponseEntity.ok(historyService.getHistory());
    }


    @GetMapping(path = "/securities/{id}/history")
    public ResponseEntity<List> getHistory(@PathVariable("id") Security security) {
        return ResponseEntity.ok(historyService.getHistory(security));
    }

}
