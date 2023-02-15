package com.ssafy.bora.controller.storybox;

import com.ssafy.bora.dto.stroybox.ReqStoryBoxDTO;
import com.ssafy.bora.dto.stroybox.ResStoryBoxDTO;
import com.ssafy.bora.service.storybox.IStoryBoxService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/storybox")
public class StoryboxController {

    private final IStoryBoxService storyBoxService;

    @PostMapping
    public ResponseEntity<?> createStoryBox(@RequestBody ReqStoryBoxDTO reqStoryBoxDTO) {
        ResStoryBoxDTO resStoryBoxDTO = storyBoxService.createStoryBox(reqStoryBoxDTO);
        return new ResponseEntity<>(resStoryBoxDTO, HttpStatus.CREATED);
    }

    @GetMapping("/list/{dj-id}")
    public ResponseEntity<Page<ResStoryBoxDTO>> findAllStoryBox(@PathVariable(name = "dj-id") String djId, Pageable pageable) {
        Page<ResStoryBoxDTO> storyBoxDtoList = storyBoxService.findAllStoryBox(djId, pageable);

        if (storyBoxDtoList != null && !storyBoxDtoList.isEmpty()) {
            return ResponseEntity.ok(storyBoxDtoList);
        }
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/list/{dj-id}/{storybox-id}")
    public ResponseEntity<?> findByDjIdAndStoryBoxId(@PathVariable(name = "dj-id") String djId, @PathVariable(name = "storybox-id") int storyBoxId) {
        ResStoryBoxDTO resStoryBoxDTO = storyBoxService.findByDjIdAndStoryBoxId(djId, storyBoxId);
        return new ResponseEntity<>(resStoryBoxDTO, HttpStatus.OK);
    }

    @DeleteMapping("/list/{storybox-id}")
    public ResponseEntity<?> deleteStoryBox(@PathVariable(name = "storybox-id") int storyBoxId) {
        ResStoryBoxDTO resStoryBoxDTO = storyBoxService.deleteOneStoryBoxByDj(storyBoxId);
        return new ResponseEntity<>(resStoryBoxDTO, HttpStatus.OK);
    }

    @DeleteMapping("/list")
    public ResponseEntity<?> deleteStoryBoxList(@RequestBody List<Integer> storyBoxList) {
        storyBoxService.deleteStoryBoxListByDj(storyBoxList);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{dj-id}/{viewer-id}")
    public ResponseEntity<?> findMyStoryBoxOfDj(@PathVariable(name = "dj-id") String djId, @PathVariable(name = "viewer-id") String viewerId) {
        ResStoryBoxDTO resStoryBoxDTO = storyBoxService.findMyStoryBoxOfDj(djId, viewerId);
        return new ResponseEntity<>(resStoryBoxDTO, HttpStatus.OK);
    }

    @PatchMapping
    public ResponseEntity<?> updateStoryBox(@RequestBody ReqStoryBoxDTO reqStoryBoxDTO) {
        ResStoryBoxDTO resStoryBoxDTO = storyBoxService.updateStoryBox(reqStoryBoxDTO);
        return new ResponseEntity<>(resStoryBoxDTO, HttpStatus.OK);
    }
}