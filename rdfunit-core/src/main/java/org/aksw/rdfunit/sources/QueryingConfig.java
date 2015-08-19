package org.aksw.rdfunit.sources;

/**
 * Querying configuration for a TestSource
 *
 * @author Dimitris Kontokostas
 * @since 8/19/15 7:57 PM
 */
final class QueryingConfig {

    /**
     * cache time to live (in ms), set to 1 week by default for endpoints
     */
    private static final long CACHE_TTL = 7l * 24l * 60l * 60l * 1000l;

    /**
     * Pagination for big results, set to 800 records by default for endpoints
     */
    private static final long PAGINATION = 800;

    /**
     * Delay between queries in a SPARQL Endpoint, set to 5 seconds by default for endpoints
     */
    private static final long QUERY_DELAY = 5l * 1000l;

    /**
     * Pose a limit on the returned results. Limit to pagination by default for endpoints
     */
    private static final long QUERY_LIMIT = PAGINATION - 1;


    private final long cacheTTL;
    private final long queryDelay;
    private final long queryLimit;
    private final long pagination;

    private QueryingConfig(long cacheTTL, long queryDelay, long queryLimit, long pagination) {
        this.cacheTTL = cacheTTL;
        this.queryDelay = queryDelay;
        this.queryLimit = queryLimit;
        this.pagination = pagination;
    }

    public static QueryingConfig create() {
        return new QueryingConfig(CACHE_TTL, QUERY_DELAY, QUERY_LIMIT, PAGINATION);
    }

    public static QueryingConfig create(long cacheTTL, long queryDelay, long queryLimit, long pagination) {
        return new QueryingConfig(cacheTTL, queryDelay, queryLimit, pagination);
    }

    public static QueryingConfig createEndpoint() {
        return create();
    }

    public static QueryingConfig createInMemory() {
        return new QueryingConfig(0,0,0,0);
    }

    public QueryingConfig copyWithNewCacheTTL(long newCacheTTL) {return create(newCacheTTL, getQueryDelay(), getQueryLimit(), getPagination());}
    public QueryingConfig copyWithNewQueryDelay(long newQueryDelay) {return create(getCacheTTL(), newQueryDelay, getQueryLimit(), getPagination());}
    public QueryingConfig copyWithNewQueryLimit(long newQueryLimit) {return create(getCacheTTL(), getQueryDelay(), newQueryLimit, getPagination());}
    public QueryingConfig copyWithNewPagination(long newPagination) {return create(getCacheTTL(), getQueryDelay(), getQueryLimit(), newPagination);}



    /**
     * The Cache tTL.
     */
    public long getCacheTTL() {
        return cacheTTL;
    }

    /**
     * The Query delay.
     */
    public long getQueryDelay() {
        return queryDelay;
    }

    /**
     * The Query limit.
     */
    public long getQueryLimit() {
        return queryLimit;
    }

    /**
     * The Pagination.
     */
    public long getPagination() {
        return pagination;
    }
}
