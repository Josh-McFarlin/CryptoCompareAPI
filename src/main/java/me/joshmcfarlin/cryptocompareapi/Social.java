package me.joshmcfarlin.cryptocompareapi;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import me.joshmcfarlin.cryptocompareapi.utils.CallTypes;
import me.joshmcfarlin.cryptocompareapi.utils.Connection;
import me.joshmcfarlin.cryptocompareapi.Exceptions.OutOfCallsException;

import java.io.*;
import java.util.List;

/**
 * Contains methods for requesting information about social media accounts for cryptocurrencies and exchanges
 * @author Josh McFarlin
 */
public class Social {
    /**
     * Gets social media information about a provided cryptocurrency or exchange
     * @param id The CryptoCompare ID to find information for
     * @return SocialStats a object containing different API data
     * @throws IOException when a connection cannot be made
     * @throws OutOfCallsException when no more API calls are available
     */
    public SocialStats getStats(int id) throws IOException, OutOfCallsException {
        String formattedUrl = "https://www.cryptocompare.com/api/data/socialstats/?id=" + id;

        Reader r = Connection.getJSON(formattedUrl, CallTypes.OTHER);
        return new Gson().fromJson(r, SocialStats.class);
    }

    /**
     * Represents social statistics provided by the CryptoCompare API
     */
    public class SocialStats {
        /**
         * Indicates request success
         */
        @SerializedName("Response")
        private String response;

        /**
         * Message provided in API response
         */
        @SerializedName("Message")
        private String message;

        /**
         * Indicates HTML request response type
         */
        @SerializedName("Type")
        private int type;

        /**
         * Social data returned by the API
         */
        @SerializedName("Data")
        private Data data;

        /**
         * {@link SocialStats#response}
         */
        public String getResponse() {
            return response;
        }

        /**
         * {@link SocialStats#message}
         */
        public String getMessage() {
            return message;
        }

        /**
         * {@link SocialStats#type}
         */
        public int getType() {
            return type;
        }

        /**
         * {@link SocialStats#data}
         */
        public Data getData() {
            return data;
        }

        /**
         * Represents data returned by the API
         */
        public class Data {
            /**
             * Represents general social info
             */
            @SerializedName("General")
            private General general;

            /**
             * Represents social info from CryptoCompare
             */
            @SerializedName("CryptoCompare")
            private CryptoCompare cryptoCompare;

            /**
             * Represents social info from Twitter
             */
            @SerializedName("Twitter")
            private Twitter twitter;

            /**
             * Represents social info from Reddit
             */
            @SerializedName("Reddit")
            private Reddit reddit;

            /**
             * Represents social info from Facebook
             */
            @SerializedName("Facebook")
            private Facebook facebook;

            /**
             * Represents social info from the coin's code repository
             */
            @SerializedName("CodeRepository")
            private CodeRepository codeRepository;

            /**
             * {@link Data#general}
             */
            public General getGeneral() {
                return general;
            }

            /**
             * {@link Data#cryptoCompare}
             */
            public CryptoCompare getCryptoCompare() {
                return cryptoCompare;
            }

            /**
             * {@link Data#twitter}
             */
            public Twitter getTwitter() {
                return twitter;
            }

            /**
             * {@link Data#reddit}
             */
            public Reddit getReddit() {
                return reddit;
            }

            /**
             * {@link Data#facebook}
             */
            public Facebook getFacebook() {
                return facebook;
            }

            /**
             * {@link Data#codeRepository}
             */
            public CodeRepository getCodeRepository() {
                return codeRepository;
            }

            /**
             * Represents general info
             */
            public class General {
                /**
                 * The coin's short name
                 */
                @SerializedName("Name")
                private String name;

                /**
                 * The coin's name
                 */
                @SerializedName("CoinName")
                private String coinName;

                /**
                 * The type
                 */
                @SerializedName("Type")
                private String type;

                /**
                 * The amount of points
                 */
                @SerializedName("Points")
                private int points;

                /**
                 * {@link General#name}
                 */
                public String getName() {
                    return name;
                }

                /**
                 * {@link General#coinName}
                 */
                public String getCoinName() {
                    return coinName;
                }

                /**
                 * {@link General#type}
                 */
                public String getType() {
                    return type;
                }

                /**
                 * {@link General#points}
                 */
                public int getPoints() {
                    return points;
                }
            }

            /**
             * Represents social info from CryptoCompare
             */
            public class CryptoCompare {
                /**
                 * Represents similar items
                 */
                @SerializedName("SimilarItems")
                private List<SimilarItem> similarItems;

                /**
                 * Represents CryptopianFollowers
                 */
                @SerializedName("CryptopianFollowers")
                private List<CryptopianFollowers> cryptopianFollowers;

                /**
                 * The number of points on CryptoCompare
                 */
                @SerializedName("Points")
                private int points;

                /**
                 * The number of followers on CryptoCompare
                 */
                @SerializedName("Followers")
                private int followers;

                /**
                 * The number of posts on CryptoCompare
                 */
                @SerializedName("Posts")
                private int posts;

                /**
                 * The number of comments on CryptoCompare
                 */
                @SerializedName("Comments")
                private int comments;

                /**
                 * Represents page views on CryptoCompare
                 */
                @SerializedName("PageViewsSplit")
                private PageViewsSplit pageViewsSplit;

                /**
                 * The number of page views CryptoCompare
                 */
                @SerializedName("PageViews")
                private int pageViews;

                /**
                 * {@link CryptoCompare#similarItems}
                 */
                public List<SimilarItem> getSimilarItems() {
                    return similarItems;
                }

                /**
                 * {@link CryptoCompare#cryptopianFollowers}
                 */
                public List<CryptopianFollowers> getCryptopianFollowers() {
                    return cryptopianFollowers;
                }

                /**
                 * {@link CryptoCompare#points}
                 */
                public int getPoints() {
                    return points;
                }

                /**
                 * {@link CryptoCompare#followers}
                 */
                public int getFollowers() {
                    return followers;
                }

                /**
                 * {@link CryptoCompare#posts}
                 */
                public int getPosts() {
                    return posts;
                }

                /**
                 * {@link CryptoCompare#comments}
                 */
                public int getComments() {
                    return comments;
                }

                /**
                 * {@link CryptoCompare#pageViewsSplit}
                 */
                public PageViewsSplit getPageViewsSplit() {
                    return pageViewsSplit;
                }

                /**
                 * {@link CryptoCompare#pageViews}
                 */
                public int getPageViews() {
                    return pageViews;
                }

                /**
                 * Represents similar items on CryptoCompare
                 */
                public class SimilarItem {
                    /**
                     * The item's id
                     */
                    @SerializedName("Id")
                    private int id;

                    /**
                     * The item's short name
                     */
                    @SerializedName("Name")
                    private String name;

                    /**
                     * The item's full name
                     */
                    @SerializedName("FullName")
                    private String fullName;

                    /**
                     * The item's image url
                     */
                    @SerializedName("ImageUrl")
                    private String imageUrl;

                    /**
                     * The item's url
                     */
                    @SerializedName("Url")
                    private String url;

                    /**
                     * An int representing the item's following type
                     */
                    @SerializedName("FollowingType")
                    private int followingType;

                    /**
                     * {@link SimilarItem#id}
                     */
                    public int getId() {
                        return id;
                    }

                    /**
                     * {@link SimilarItem#name}
                     */
                    public String getName() {
                        return name;
                    }

                    /**
                     * {@link SimilarItem#fullName}
                     */
                    public String getFullName() {
                        return fullName;
                    }

                    /**
                     * {@link SimilarItem#imageUrl}
                     */
                    public String getImageUrl() {
                        return imageUrl;
                    }

                    /**
                     * {@link SimilarItem#url}
                     */
                    public String getUrl() {
                        return url;
                    }

                    /**
                     * {@link SimilarItem#followingType}
                     */
                    public int getFollowingType() {
                        return followingType;
                    }
                }

                /**
                 * Represents CryptopianFollowers
                 */
                public class CryptopianFollowers {
                    /**
                     * The follower's id
                     */
                    @SerializedName("Id")
                    private int id;

                    /**
                     * The follower's name
                     */
                    @SerializedName("Name")
                    private String name;

                    /**
                     * The follower's image url
                     */
                    @SerializedName("ImageUrl")
                    private String imageUrl;

                    /**
                     * The follower's url
                     */
                    @SerializedName("Url")
                    private String url;

                    /**
                     * The follower's type
                     */
                    @SerializedName("Type")
                    private String type;

                    /**
                     * {@link CryptopianFollowers#id}
                     */
                    public int getId() {
                        return id;
                    }

                    /**
                     * {@link CryptopianFollowers#name}
                     */
                    public String getName() {
                        return name;
                    }

                    /**
                     * {@link CryptopianFollowers#imageUrl}
                     */
                    public String getImageUrl() {
                        return imageUrl;
                    }

                    /**
                     * {@link CryptopianFollowers#url}
                     */
                    public String getUrl() {
                        return url;
                    }

                    /**
                     * {@link CryptopianFollowers#type}
                     */
                    public String getType() {
                        return type;
                    }
                }

                /**
                 * Represents PageViewsSplit
                 */
                public class PageViewsSplit {
                    /**
                     * The int representing overview
                     */
                    @SerializedName("Overview")
                    private int overview;

                    /**
                     * The int representing markets
                     */
                    @SerializedName("Markets")
                    private int markets;

                    /**
                     * The int representing analysis
                     */
                    @SerializedName("Analysis")
                    private int analysis;

                    /**
                     * The int representing charts
                     */
                    @SerializedName("Charts")
                    private int charts;

                    /**
                     * The int representing trades
                     */
                    @SerializedName("Trades")
                    private int trades;

                    /**
                     * The int representing the orderbook
                     */
                    @SerializedName("Orderbook")
                    private int orderbook;

                    /**
                     * The int representing the form
                     */
                    @SerializedName("Forum")
                    private int forum;

                    /**
                     * The int representing the influence
                     */
                    @SerializedName("Influence")
                    private int influence;

                    /**
                     * {@link PageViewsSplit#overview}
                     */
                    public int getOverview() {
                        return overview;
                    }

                    /**
                     * {@link PageViewsSplit#markets}
                     */
                    public int getMarkets() {
                        return markets;
                    }

                    /**
                     * {@link PageViewsSplit#analysis}
                     */
                    public int getAnalysis() {
                        return analysis;
                    }

                    /**
                     * {@link PageViewsSplit#charts}
                     */
                    public int getCharts() {
                        return charts;
                    }

                    /**
                     * {@link PageViewsSplit#trades}
                     */
                    public int getTrades() {
                        return trades;
                    }

                    /**
                     * {@link PageViewsSplit#orderbook}
                     */
                    public int getOrderbook() {
                        return orderbook;
                    }

                    /**
                     * {@link PageViewsSplit#forum}
                     */
                    public int getForum() {
                        return forum;
                    }

                    /**
                     * {@link PageViewsSplit#influence}
                     */
                    public int getInfluence() {
                        return influence;
                    }
                }
            }

            /**
             * Represents social data from Twitter
             */
            public class Twitter {
                /**
                 * The number of followers on Twitter
                 */
                private int following;

                /**
                 * When the account was created
                 */
                @SerializedName("account_creation")
                private int accountCreation;

                /**
                 * The Twitter account's name
                 */
                private String name;

                /**
                 * The number of lists
                 */
                private int lists;

                /**
                 * The number of statuses
                 */
                private int statuses;

                /**
                 * The number of favourites
                 */
                private int favourites;

                /**
                 * The number of followers
                 */
                private int followers;

                /**
                 * The account's link
                 */
                private String link;

                /**
                 * The number of points
                 */
                @SerializedName("Points")
                private int points;

                /**
                 * {@link Twitter#following}
                 */
                public int getFollowing() {
                    return following;
                }

                /**
                 * {@link Twitter#accountCreation}
                 */
                public int getAccountCreation() {
                    return accountCreation;
                }

                /**
                 * {@link Twitter#name}
                 */
                public String getName() {
                    return name;
                }

                /**
                 * {@link Twitter#lists}
                 */
                public int getLists() {
                    return lists;
                }

                /**
                 * {@link Twitter#statuses}
                 */
                public int getStatuses() {
                    return statuses;
                }

                /**
                 * {@link Twitter#favourites}
                 */
                public int getFavourites() {
                    return favourites;
                }

                /**
                 * {@link Twitter#followers}
                 */
                public int getFollowers() {
                    return followers;
                }

                /**
                 * {@link Twitter#link}
                 */
                public String getLink() {
                    return link;
                }

                /**
                 * {@link Twitter#points}
                 */
                public int getPoints() {
                    return points;
                }
            }

            /**
             * Represents social data from Reddit
             */
            public class Reddit {
                /**
                 * The number of posts per hour on Reddit
                 */
                @SerializedName("posts_per_hour")
                private double postsPerHour;

                /**
                 * The number of comments per hour on Reddit
                 */
                @SerializedName("comments_per_hour")
                private double commentsPerHour;

                /**
                 * The number of posts per day on Reddit
                 */
                @SerializedName("posts_per_day")
                private double postsPerDay;

                /**
                 * The number of comments per day on Reddit
                 */
                @SerializedName("comments_per_day")
                private double commentsPerDay;

                /**
                 * The name of the subreddit
                 */
                private String name;

                /**
                 * The link to the subreddit
                 */
                private String link;

                /**
                 * The number of active users on the subreddit
                 */
                @SerializedName("active_users")
                private int activeUsers;

                /**
                 * When the subreddit was created
                 */
                @SerializedName("community_creation")
                private int communityCreation;

                /**
                 * The number of users subscribed to the subreddit
                 */
                private int subscribers;

                /**
                 * The number of points
                 */
                @SerializedName("Points")
                private int points;

                /**
                 * {@link Reddit#postsPerHour}
                 */
                public double getPostsPerHour() {
                    return postsPerHour;
                }

                /**
                 * {@link Reddit#commentsPerHour}
                 */
                public double getCommentsPerHour() {
                    return commentsPerHour;
                }

                /**
                 * {@link Reddit#postsPerDay}
                 */
                public double getPostsPerDay() {
                    return postsPerDay;
                }

                /**
                 * {@link Reddit#commentsPerDay}
                 */
                public double getCommentsPerDay() {
                    return commentsPerDay;
                }

                /**
                 * {@link Reddit#name}
                 */
                public String getName() {
                    return name;
                }

                /**
                 * {@link Reddit#link}
                 */
                public String getLink() {
                    return link;
                }

                /**
                 * {@link Reddit#activeUsers}
                 */
                public int getActiveUsers() {
                    return activeUsers;
                }

                /**
                 * {@link Reddit#communityCreation}
                 */
                public int getCommunityCreation() {
                    return communityCreation;
                }

                /**
                 * {@link Reddit#subscribers}
                 */
                public int getSubscribers() {
                    return subscribers;
                }

                /**
                 * {@link Reddit#points}
                 */
                public int getPoints() {
                    return points;
                }
            }

            /**
             * Represents social data from Facebook
             */
            public class Facebook {
                /**
                 * The number of likes on Facebook
                 */
                private int likes;

                /**
                 * The link to the Facebook page
                 */
                private String link;

                /**
                 * If the Facebook page is closed
                 */
                @SerializedName("is_closed")
                private boolean isClosed;

                /**
                 * The number of people talking about the item
                 */
                @SerializedName("talking_about")
                private int talkingAbout;

                /**
                 * The name of the Facebook page
                 */
                private String name;

                /**
                 * The number of points
                 */
                @SerializedName("Points")
                private int points;

                /**
                 * {@link Facebook#likes}
                 */
                public int getLikes() {
                    return likes;
                }

                /**
                 * {@link Facebook#link}
                 */
                public String getLink() {
                    return link;
                }

                /**
                 * {@link Facebook#isClosed}
                 */
                public boolean isClosed() {
                    return isClosed;
                }

                /**
                 * {@link Facebook#talkingAbout}
                 */
                public int getTalkingAbout() {
                    return talkingAbout;
                }

                /**
                 * {@link Facebook#name}
                 */
                public String getName() {
                    return name;
                }

                /**
                 * {@link Facebook#points}
                 */
                public int getPoints() {
                    return points;
                }
            }

            /**
             * Represents social data from a code repository
             */
            public class CodeRepository {
                /**
                 * A list of code repository objects
                 */
                @SerializedName("List")
                private List<CodeEntry> list;

                /**
                 * The number of points
                 */
                @SerializedName("Points")
                private int points;

                /**
                 * {@link CodeRepository#list}
                 */
                public List<CodeEntry> getList() {
                    return list;
                }

                /**
                 * {@link CodeRepository#points}
                 */
                public int getPoints() {
                    return points;
                }

                /**
                 * Represents data about a code repository
                 */
                public class CodeEntry {
                    /**
                     * When the repository was created
                     */
                    @SerializedName("created_at")
                    private int createdAt;

                    /**
                     * The number of open issues on the repository
                     */
                    @SerializedName("open_total_issues")
                    private int openTotalIssues;

                    /**
                     * The repository's parent
                     */
                    @SerializedName("Parent")
                    private Parent parent;

                    /**
                     * The size of the repository
                     */
                    private int size;

                    /**
                     * The total number of closed issues on the repository
                     */
                    @SerializedName("closed_total_issues")
                    private int closedTotalIssues;

                    /**
                     * The number of stars on the repository
                     */
                    private int stars;

                    /**
                     * When the code repository was last updated
                     */
                    @SerializedName("last_update")
                    private int lastUpdate;

                    /**
                     * The number of forks of the repository
                     */
                    private int forks;

                    /**
                     * The url to the repository
                     */
                    private String url;

                    /**
                     * The number of closed issues on the repository
                     */
                    @SerializedName("closed_issues")
                    private int closedIssues;

                    /**
                     * The number of closed pull issues on the repository
                     */
                    @SerializedName("closed_pull_issues")
                    private int closedPullIssues;

                    /**
                     * If the code repository is a fork of another repository
                     */
                    private boolean fork;

                    /**
                     * When the repository was last pushed code
                     */
                    @SerializedName("last_push")
                    private int lastPush;

                    /**
                     * Represents the source
                     */
                    private Source source;

                    /**
                     * The number of open pull issues on the repository
                     */
                    @SerializedName("open_pull_issues")
                    private int openPullIssues;

                    /**
                     * The language of the repository
                     */
                    private String language;

                    /**
                     * The number of subscribers to the repository
                     */
                    private int subscribers;

                    /**
                     * The number of open issues on the repository
                     */
                    @SerializedName("open_issues")
                    private int openIssues;

                    /**
                     * {@link CodeEntry#createdAt}
                     */
                    public int getCreatedAt() {
                        return createdAt;
                    }

                    /**
                     * {@link CodeEntry#openTotalIssues}
                     */
                    public int getOpenTotalIssues() {
                        return openTotalIssues;
                    }

                    /**
                     * {@link CodeEntry#parent}
                     */
                    public Parent getParent() {
                        return parent;
                    }

                    /**
                     * {@link CodeEntry#size}
                     */
                    public int getSize() {
                        return size;
                    }

                    /**
                     * {@link CodeEntry#closedTotalIssues}
                     */
                    public int getClosedTotalIssues() {
                        return closedTotalIssues;
                    }

                    /**
                     * {@link CodeEntry#stars}
                     */
                    public int getStars() {
                        return stars;
                    }

                    /**
                     * {@link CodeEntry#lastUpdate}
                     */
                    public int getLastUpdate() {
                        return lastUpdate;
                    }

                    /**
                     * {@link CodeEntry#forks}
                     */
                    public int getForks() {
                        return forks;
                    }

                    /**
                     * {@link CodeEntry#url}
                     */
                    public String getUrl() {
                        return url;
                    }

                    /**
                     * {@link CodeEntry#closedIssues}
                     */
                    public int getClosedIssues() {
                        return closedIssues;
                    }

                    /**
                     * {@link CodeEntry#closedPullIssues}
                     */
                    public int getClosedPullIssues() {
                        return closedPullIssues;
                    }

                    /**
                     * {@link CodeEntry#fork}
                     */
                    public boolean isFork() {
                        return fork;
                    }

                    /**
                     * {@link CodeEntry#lastPush}
                     */
                    public int getLastPush() {
                        return lastPush;
                    }

                    /**
                     * {@link CodeEntry#source}
                     */
                    public Source getSource() {
                        return source;
                    }

                    /**
                     * {@link CodeEntry#openPullIssues}
                     */
                    public int getOpenPullIssues() {
                        return openPullIssues;
                    }

                    /**
                     * {@link CodeEntry#language}
                     */
                    public String getLanguage() {
                        return language;
                    }

                    /**
                     * {@link CodeEntry#subscribers}
                     */
                    public int getSubscribers() {
                        return subscribers;
                    }

                    /**
                     * {@link CodeEntry#openIssues}
                     */
                    public int getOpenIssues() {
                        return openIssues;
                    }

                    /**
                     * Represents data about a repository's parent
                     */
                    public class Parent {
                        /**
                         * The name of the repository's parent
                         */
                        @SerializedName("Name")
                        private String name;

                        /**
                         * The url to the repository's parent
                         */
                        @SerializedName("Url")
                        private String url;

                        /**
                         * The internal id of the repository's parent
                         */
                        @SerializedName("InternalId")
                        private int internalId;

                        /**
                         * {@link Parent#name}
                         */
                        public String getName() {
                            return name;
                        }

                        /**
                         * {@link Parent#url}
                         */
                        public String getUrl() {
                            return url;
                        }

                        /**
                         * {@link Parent#internalId}
                         */
                        public int getInternalId() {
                            return internalId;
                        }
                    }

                    /**
                     * Represents data about a repository's source
                     */
                    public class Source {
                        /**
                         * The name of the repository's source
                         */
                        @SerializedName("Name")
                        private String name;

                        /**
                         * The url to the repository's source
                         */
                        @SerializedName("Url")
                        private String url;

                        /**
                         * The internal id of the repository's source
                         */
                        @SerializedName("InternalId")
                        private int internalId;

                        /**
                         * {@link Source#name}
                         */
                        public String getName() {
                            return name;
                        }

                        /**
                         * {@link Source#url}
                         */
                        public String getUrl() {
                            return url;
                        }

                        /**
                         * {@link Source#internalId}
                         */
                        public int getInternalId() {
                            return internalId;
                        }
                    }
                }
            }
        }
    }
}
