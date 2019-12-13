package app.controller;

import app.entity.Publisher;
import app.model.PublisherBean;
import app.service.PublisherService;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * AuthorController.class
 */
@RestController
public class PublisherController extends BaseController {
    private static final Log LOG = LogFactory.getLog(PublisherController.class.getName());

    @Autowired
    PublisherService publisherService;

    @RequestMapping(value = "/publishers", method = RequestMethod.GET, produces = "application/json")
    public List<Publisher> getPublisherListingPage() {
        return publisherService.getAllPublishers();
    }

    @RequestMapping(value = "/publishers/{id}", method = RequestMethod.GET, produces = "application/json")
    public PublisherBean getPublisherPage(@PathVariable String id) {
        PublisherBean bean = new PublisherBean();
        if (StringUtils.isNotBlank(id)) {
            Publisher publisher = publisherService.getPublisherById(new Long(id)).get();
            BeanUtils.copyProperties(publisher,bean);
        }
        return bean;
    }

    @PostMapping(path = "/publishers/publisher-add", consumes = "application/json", produces = "application/json")
    public void addPublisherPage(@RequestBody PublisherBean bean) {
        bean.setId(new Long(0));

        Publisher publisher = new Publisher();

        BeanUtils.copyProperties(bean,publisher);

        publisher.setCreatedDt(getCurrentDate());
        publisher.setCreatedBy("Admin");
        publisher.setUpdatedDt(getCurrentDate());
        publisher.setUpdatedBy("Admin");
        Publisher recentlyAddedPublisher = publisherService.addPublisher(publisher);
        LOG.debug("Latest publisher added id ["+recentlyAddedPublisher.getId()+"]");
    }

    @PostMapping(path = "/publishers/publisher-edit", consumes = "application/json", produces = "application/json")
    public void editPublisherPage(@RequestBody PublisherBean bean) {
        Publisher publisher = new Publisher();
        BeanUtils.copyProperties(bean,publisher);

        publisher.setUpdatedDt(getCurrentDate());
        publisher.setUpdatedBy("Admin");
        Publisher recentlyAddedAuthor = publisherService.addPublisher(publisher);
        LOG.debug("Latest publisher added id ["+recentlyAddedAuthor.getId()+"]");
    }
}