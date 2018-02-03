package DTO;

import java.util.List;

public class Show {
    public Show() {

    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    int id;

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    String url;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    String name;

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    String type;

    public String getLanguage() {
        return this.language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    String language;

    public List<String> getGenres() {
        return this.genres;
    }

    public void setGenres(List<String> genres) {
        this.genres = genres;
    }

    List<String> genres;

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    String status;

    public int getRuntime() {
        return this.runtime;
    }

    public void setRuntime(int runtime) {
        this.runtime = runtime;
    }

    int runtime;

    public String getPremiered() {
        return this.premiered;
    }

    public void setPremiered(String premiered) {
        this.premiered = premiered;
    }

    String premiered;

    public String getOfficialSite() {
        return this.officialSite;
    }

    public void setOfficialSite(String officialSite) {
        this.officialSite = officialSite;
    }

    String officialSite;

    public Schedule getSchedule() {
        return this.schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

    Schedule schedule;

    public Rating getRating() {
        return this.rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

    Rating rating;

    public int getWeight() {
        return this.weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    int weight;

    public Network getNetwork() {
        return this.network;
    }

    public void setNetwork(Network network) {
        this.network = network;
    }

    Network network;

    public Object getWebChannel() {
        return this.webChannel;
    }

    public void setWebChannel(Object webChannel) {
        this.webChannel = webChannel;
    }

    Object webChannel;

    public Externals getExternals() {
        return this.externals;
    }

    public void setExternals(Externals externals) {
        this.externals = externals;
    }

    Externals externals;

    public Image getImage() {
        return this.image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    Image image;

    public String getSummary() {
        return this.summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    String summary;

    public int getUpdated() {
        return this.updated;
    }

    public void setUpdated(int updated) {
        this.updated = updated;
    }

    int updated;

    public Links get_links() {
        return this._links;
    }

    public void set_links(Links _links) {
        this._links = _links;
    }

    Links _links;

}