package me.joshmcfarlin.cryptocompareapi;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import me.joshmcfarlin.cryptocompareapi.Utils.CallTypes;
import me.joshmcfarlin.cryptocompareapi.Utils.Connection;
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
     * @return SocialStats a class containing different API data
     * @throws IOException when a connection cannot be made
     * @throws OutOfCallsException when no more API calls are available
     */
    public static SocialStats getStats(int id) throws IOException, OutOfCallsException, InterruptedException {
        String formattedUrl = "https://www.cryptocompare.com/api/data/socialstats/?id=" + id;
        Reader r = Connection.getJSON(formattedUrl, CallTypes.OTHER);
        return new Gson().fromJson(r, SocialStats.class);
    }

    public class SocialStats {
        @SerializedName("Response")
        String response;
        @SerializedName("Message")
        String message;
        @SerializedName("Type")
        int type;
        @SerializedName("Data")
        Data data;

        public class Data {
            @SerializedName("General")
            General general;
            @SerializedName("CryptoCompare")
            CryptoCompare cryptoCompare;
            @SerializedName("Twitter")
            Twitter twitter;
            @SerializedName("Reddit")
            Reddit reddit;
            @SerializedName("Facebook")
            Facebook facebook;
            @SerializedName("CodeRepository")
            CodeRepository codeRepository;

            public class General {
                @SerializedName("Name")
                String name;
                @SerializedName("CoinName")
                String coinName;
                @SerializedName("Type")
                String type;
                @SerializedName("Points")
                int points;
            }

            public class CryptoCompare {
                @SerializedName("SimilarItems")
                List<SimilarItem> similarItems;
                @SerializedName("CryptopianFollowers")
                List<CryptopianFollowers> cryptopianFollowers;
                @SerializedName("Points")
                int points;
                @SerializedName("Followers")
                int followers;
                @SerializedName("Posts")
                int posts;
                @SerializedName("Comments")
                int comments;
                @SerializedName("PageViewsSplit")
                PageViewsSplit pageViewsSplit;
                @SerializedName("PageViews")
                int pageViews;

                public class SimilarItem {
                    @SerializedName("Id")
                    int id;
                    @SerializedName("Name")
                    String name;
                    @SerializedName("FullName")
                    String fullName;
                    @SerializedName("ImageUrl")
                    String imageUrl;
                    @SerializedName("Url")
                    String url;
                    @SerializedName("FollowingType")
                    int followingType;
                }

                public class CryptopianFollowers {
                    @SerializedName("Id")
                    int id;
                    @SerializedName("Name")
                    String name;
                    @SerializedName("ImageUrl")
                    String imageUrl;
                    @SerializedName("Url")
                    String url;
                    @SerializedName("Type")
                    String type;
                }

                public class PageViewsSplit {
                    @SerializedName("Overview")
                    int overview;
                    @SerializedName("Markets")
                    int markets;
                    @SerializedName("Analysis")
                    int analysis;
                    @SerializedName("Charts")
                    int charts;
                    @SerializedName("Trades")
                    int trades;
                    @SerializedName("Orderbook")
                    int orderbook;
                    @SerializedName("Forum")
                    int forum;
                    @SerializedName("Influence")
                    int influence;
                }
            }

            public class Twitter {
                int following;
                @SerializedName("account_creation")
                int accountCreation;
                String name;
                int lists;
                int statuses;
                int favourites;
                int followers;
                String link;
                @SerializedName("Points")
                int points;
            }

            public class Reddit {
                @SerializedName("posts_per_hour")
                double postsPerHour;
                @SerializedName("comments_per_hour")
                double commentsPerHour;
                @SerializedName("posts_per_day")
                double postsPerDay;
                @SerializedName("comments_per_day")
                double commentsPerDay;
                String name;
                String link;
                @SerializedName("active_users")
                int activeUsers;
                @SerializedName("community_creation")
                int communityCreation;
                int subscribers;
                @SerializedName("Points")
                int points;
            }

            public class Facebook {
                int likes;
                String link;
                @SerializedName("is_closed")
                boolean isClosed;
                @SerializedName("talking_about")
                int talkingAbout;
                String name;
                @SerializedName("Points")
                int points;
            }

            public class CodeRepository {
                @SerializedName("List")
                List<CodeEntry> list;
                @SerializedName("Points")
                int points;

                public class CodeEntry {
                    @SerializedName("created_at")
                    int createdAt;
                    @SerializedName("open_total_issues")
                    int openTotalIssues;
                    @SerializedName("Parent")
                    Parent parent;
                    int size;
                    @SerializedName("closed_total_issues")
                    int closedTotalIssues;
                    int stars;
                    @SerializedName("last_update")
                    int lastUpdate;
                    int forks;
                    String url;
                    @SerializedName("closed_issues")
                    int closedIssues;
                    @SerializedName("closed_pull_issues")
                    int closedPullIssues;
                    boolean fork;
                    @SerializedName("last_push")
                    int lastPush;
                    Source source;
                    @SerializedName("open_pull_issues")
                    int openPullIssues;
                    String language;
                    int subscribers;
                    @SerializedName("open_issues")
                    int openIssues;

                    public class Parent {
                        @SerializedName("Name")
                        String name;
                        @SerializedName("Url")
                        String url;
                        @SerializedName("InternalId")
                        int internalId;
                    }

                    public class Source {
                        @SerializedName("Name")
                        String name;
                        @SerializedName("Url")
                        String url;
                        @SerializedName("InternalId")
                        int internalId;
                    }
                }
            }
        }
    }
}
