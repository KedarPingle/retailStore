package com.mo.retailStore.controller;


import com.mo.retailStore.model.Product;
import com.mo.retailStore.service.ProductService;
import com.mo.retailStore.util.LocalizationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class ProductController {

	@Autowired
	private ProductService productService;

	@RequestMapping(value = "/product/all", method = RequestMethod.GET)
    public @ResponseBody Iterable<Product> getAllProducts() throws IOException {
        return productService.getAllProducts();
    }

    @RequestMapping(value = "/product/{resourceId}", method = RequestMethod.GET)
    public @ResponseBody Product getProduct(@PathVariable(value="resourceId") String resourceId) throws IOException {
        return productService.getProduct(resourceId);
    }
	
	/*@CrossOrigin
	@RequestMapping(value = "/segment/{resourceId}", method = RequestMethod.GET)
    public @ResponseBody Segment getSegment(@PathVariable(value="resourceId") String resourceId) throws IOException {
        return segmentService.getSegment(resourceId);
    }
	
	@RequestMapping(value = "/segment/add", consumes = "application/json", method = RequestMethod.POST)
    public @ResponseBody String addSegment(@RequestBody Segment segment) throws JsonProcessingException {
		return segmentService.addSegment(segment);
    }
	
	@CrossOrigin
    @RequestMapping(value = "/segment-exists/{resourceId}", method = RequestMethod.GET)
    public @ResponseBody Boolean doesSegmentExist(@PathVariable(value="resourceId") String resourceId) throws IOException {
        return segmentService.doesSegmentExist(resourceId);
    }

    @CrossOrigin
    @RequestMapping(value = "/update-segment", consumes = "application/json", method = RequestMethod.POST)
    public @ResponseBody Boolean updateSegmentsAndTranslationForLocales(@RequestBody Segment segment) throws Exception {
        return segmentService.updateSegmentsAndTranslationForLocales(segment);
    }

    @CrossOrigin
    @RequestMapping(value = "/projects-sharing-segments/{projectId}", method = RequestMethod.GET)
    public @ResponseBody
    Set<String> getProjectsSharingSegments(@PathVariable(value="projectId") String projectId) throws Exception {
        return segmentService.getProjectsSharingSegments(projectId);
    }

    @CrossOrigin
    @RequestMapping(value = "/segments-translatability-by-project", consumes = "application/json", method = RequestMethod.POST)
    public @ResponseBody
    List<Segment> getSegmentsWithTranslatabilityStatusForProjects(@RequestBody SegmentTranslatability segment) throws Exception {
        return segmentService.getSegmentsWithTranslatabilityStatusForProjects(segment);
    }

    @CrossOrigin
    @RequestMapping(value = "/assign-segment-translatability-to", consumes = "application/json", method = RequestMethod.POST)
    public @ResponseBody
    Boolean assignSegmentTranslatabilityToUser(@RequestBody SegmentTranslatability segment) throws Exception {
        return segmentService.assignSegmentTranslatabilityToUser(segment);
    }

    @CrossOrigin
    @RequestMapping(value = "/all-segments-translatability-by-project", consumes = "application/json", method = RequestMethod.POST)
    public @ResponseBody
    List<Segment> getAllSegmentsForProjects(@RequestBody SegmentTranslatability segment) throws Exception {
        return segmentService.getAllSegmentsForProjects(segment);
    }

    @CrossOrigin
    @RequestMapping(value = "/user-assigned-segments-by-project", consumes = "application/json", method = RequestMethod.POST)
    public @ResponseBody
    List<Segment> getUserAssignedSegmentsForProjects(@RequestBody SegmentTranslatability segment) throws Exception {
        return segmentService.getUserAssignedSegmentsForProjects(segment);
    }

    @CrossOrigin
    @RequestMapping(value = "/segment-with-segmentquality/{resourceId}", method = RequestMethod.GET)
    public @ResponseBody Segment getSegmentWithSegmentQuality(@PathVariable(value="resourceId") String resourceId) throws IOException {
        return segmentService.getSegmentWithSegmentQuality(resourceId);
    }

    @CrossOrigin
    @RequestMapping(value = "review-segment-update", consumes = "application/json", method = RequestMethod.POST)
    public @ResponseBody
    Boolean reviewSegmentUpdate(@RequestBody SegmentQualityReview segmentQualityReview) throws Exception {
        return segmentService.reviewSegmentUpdate(segmentQualityReview);
    }

    @CrossOrigin
    @RequestMapping(value = "project-segment-update", consumes = "application/json", method = RequestMethod.POST)
    public @ResponseBody
    String projectSegmentUpdate(@RequestBody ProjectSegmentsHolder projectSegmentsHolder) throws Exception {
        return segmentProjectService.projectSegmentUpdate(projectSegmentsHolder);
    }

    @CrossOrigin
    @RequestMapping(value = "/segments-translatability-status-count-project", consumes = "application/json", method = RequestMethod.POST)
    public @ResponseBody
    List<ProjectSegmentsTranslationStatus> getSegmentsTranslatabilityStatusCountForProjects(@RequestBody SegmentTranslatability segment) throws Exception {
        return segmentService.getSegmentsCountForProjects(segment);
    }

    @CrossOrigin
    @RequestMapping(value = "/all-removed-segments", method = RequestMethod.GET)
    public @ResponseBody Iterable<Segment> getAllRemovedSegments() throws IOException {
        return segmentService.getAllRemovedSegments();
    }

    @CrossOrigin
    @RequestMapping(value = "/segment/staged/count", method = RequestMethod.GET)
    public @ResponseBody int getCountOfAllStagedSegments() throws IOException {

        return segmentProjectService.getCountOfAllSegmentsByStatus("STAGED");
    }

    @CrossOrigin
    @RequestMapping(value = "/segment-translation/staged", method = RequestMethod.GET)
    public @ResponseBody Iterable<SegmentTranslation> getAllStagedSegments() throws IOException {
        return segmentProjectService.getAllSegmentTranslationsByStatus("STAGED");
    }

    @CrossOrigin
    @RequestMapping(value = "/segments-pagination", method = RequestMethod.GET)
    public @ResponseBody
    Iterable<Segment> getAllSegmentsByPagination(Pageable pageable) throws IOException {
        return segmentService.getAllSegmentsByPagination(pageable);
    }

    @CrossOrigin
    @RequestMapping(value = "/segments-count", method = RequestMethod.GET)
    public @ResponseBody
    Long getAllSegmentsCount() throws IOException {
        return segmentService.getAllSegmentsCount();
    }*/
}