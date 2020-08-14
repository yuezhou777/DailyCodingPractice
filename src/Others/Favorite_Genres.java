package Others;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a map Map<String, List<String>> userSongs with user names as keys and a list of all the songs that the user has listened to as values.
 *
 * Also given a map Map<String, List<String>> songGenres, with song genre as keys and a list of all the songs within that genre as values. The song can only belong to only one genre.
 *
 * The task is to return a map Map<String, List<String>>, where the key is a user name and the value is a list of the user's favorite genre(s). Favorite genre is the most listened to genre. A user can have more than one favorite genre if he/she has listened to the same number of songs per each of the genres.
 *
 * Example 1:
 *
 * Input:
 * userSongs = {
 *    "David": ["song1", "song2", "song3", "song4", "song8"],
 *    "Emma":  ["song5", "song6", "song7"]
 * },
 * songGenres = {
 *    "Rock":    ["song1", "song3"],
 *    "Dubstep": ["song7"],
 *    "Techno":  ["song2", "song4"],
 *    "Pop":     ["song5", "song6"],
 *    "Jazz":    ["song8", "song9"]
 * }
 *
 * Output: {
 *    "David": ["Rock", "Techno"],
 *    "Emma":  ["Pop"]
 * }
 *
 * Explanation:
 * David has 2 Rock, 2 Techno and 1 Jazz song. So he has 2 favorite genres.
 * Emma has 2 Pop and 1 Dubstep song. Pop is Emma's favorite genre.
 * Example 2:
 *
 * Input:
 * userSongs = {
 *    "David": ["song1", "song2"],
 *    "Emma":  ["song3", "song4"]
 * },
 * songGenres = {}
 *
 * Output: {
 *    "David": [],
 *    "Emma":  []
 * }
 */

public class Favorite_Genres {
    public Map<String, List<String>> favoritegenre(Map<String, List<String>> userMap, Map<String, List<String>> genreMap) {
        HashMap<String, String> songToGenre = getGenreBySong(genreMap);
        HashMap<String, List<String>> res = new HashMap<>();
        for (String name : userMap.keySet()) {
            res.put(name, new ArrayList<>());
            int max = 0;
            HashMap<String, Integer> genreCount = new HashMap<>();
            for (String song : userMap.get(name)) {
                String genre = songToGenre.get(song);
                int count = genreCount.getOrDefault(genre, 0) + 1;
                genreCount.put(genre, count);
                max = Math.max(count, max);
            }
            for (String genre : genreCount.keySet()) {
                if (genreCount.get(genre) == max) {
                    res.get(name).add(genre);
                }
            }
        }

        return res;
    }

    private HashMap<String, String> getGenreBySong(Map<String, List<String>> genreMap) {
        HashMap<String, String> songToGenre = new HashMap<>();
        for (String genre : genreMap.keySet()) {
            List<String> songList = genreMap.get(genre);
            for (String song : songList) {
                songToGenre.put(song, genre);
            }
        }
        return songToGenre;
    }

    public static void main(String[] args) {
        Map<String, List<String>> userMap = new HashMap<>();
        userMap.put("David", new ArrayList<>());
            userMap.get("David").add("song1");
            userMap.get("David").add("song2");
            userMap.get("David").add("song3");
            userMap.get("David").add("song4");
            userMap.get("David").add("song8");
        userMap.put("Emma", new ArrayList<>());
            userMap.get("Emma").add("song5");
            userMap.get("Emma").add("song6");
            userMap.get("Emma").add("song7");

        Map<String, List<String>> genreMap = new HashMap<>();
        genreMap.put("Rock", new ArrayList<>());
            genreMap.get("Rock").add("song1");
            genreMap.get("Rock").add("song3");
        genreMap.put("Dubstep", new ArrayList<>());
            genreMap.get("Dubstep").add("song7");
        genreMap.put("Techno", new ArrayList<>());
            genreMap.get("Techno").add("song2");
            genreMap.get("Techno").add("song4");
        genreMap.put("Pop", new ArrayList<>());
            genreMap.get("Pop").add("song5");
            genreMap.get("Pop").add("song6");
        genreMap.put("Jazz", new ArrayList<>());
            genreMap.get("Jazz").add("song8");
            genreMap.get("Jazz").add("song9");

        Favorite_Genres fg = new Favorite_Genres(){};
        Map<String, List<String>> res = fg.favoritegenre(userMap, genreMap);
        for (String name : res.keySet()) {
            System.out.println(name + ": ");
            for (String genre : res.get(name)) {
                System.out.print(genre + ", ");
            }
            System.out.println();
        }
    }
}
