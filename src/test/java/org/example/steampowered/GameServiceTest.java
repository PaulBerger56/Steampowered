package org.example.steampowered;

import org.example.steampowered.pojo.Game;
import org.example.steampowered.repository.GameRepository;
import org.example.steampowered.service.GameService;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class GameServiceTest {

    @Mock
    private GameRepository gameRepository;

    @InjectMocks
    private GameService gameService;

    private Map<String, Game> gamesMap;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetGamesFromRepo() {
        // Mocking data
        gamesMap = new HashMap<>();
        gamesMap.put("1", new Game("1", "Game 1", "img1", "desc1"));
        gamesMap.put("2", new Game("2", "Game 2", "img2", "desc2"));

        // Stubbing the behavior of the repository mock
        when(gameRepository.getGames()).thenReturn((HashMap<String, Game>) gamesMap);

        // Calling the method under test
        Collection<Game> games = gameService.getGames();

        // Assertions
        Assertions.assertNotNull(games);
        Assertions.assertEquals(2, games.size());
    }

    @Test
    public void testGetGameFromRepo() {
        // Mocking data
        Game game = new Game("1", "Game 1", "img1", "desc1");

        // Stubbing the behavior of the repository mock
        when(gameRepository.getGame("1")).thenReturn(game);

        // Calling the method under test
        Game result = gameService.getGame("1");

        // Assertions
        Assertions.assertNotNull(result);
        Assertions.assertEquals("1", result.getAppId());
        Assertions.assertEquals("Game 1", result.getName());
        Assertions.assertEquals("img1", result.getImgIconURL());
        Assertions.assertEquals("desc1", result.getShortDescription());
    }

    @Test
    public void testAddGameToRepository() {
        Game game = new Game("1", "Game 1", "img1", "desc1");

        when(gameRepository.getGame("1")).thenReturn(null);

        gameService.addGame(game);

        when(gameRepository.getGame("1")).thenReturn(game);

        Game result = gameService.getGame("1");

        Assertions.assertNotNull(result);

    }

    @Test
    public void testDeleteGameFromRepository() {
        Game game = new Game("1", "Game 1", "img1", "desc1");

        when(gameRepository.getGame("1")).thenReturn(game);

        gameService.deleteGame("1");

        when(gameRepository.getGame("1")).thenReturn(null);

        Game result = gameService.getGame("1");

        Assertions.assertNull(result);
    }

    @Test
    public void testGetGamesAsJson() {
        // Mocking data
        gamesMap = new HashMap<>();
        gamesMap.put("1", new Game("1", "Game 1", "img1", "desc1"));
        gamesMap.put("2", new Game("2", "Game 2", "img2", "desc2"));

        // Stubbing the behavior of the repository mock
        when(gameRepository.getGames()).thenReturn((HashMap<String, Game>) gamesMap);

        // Calling the method under test
        String gamesJson = gameService.getGamesAsJson();

        // Assertions
        Assertions.assertNotNull(gamesJson);
    }

    @Test
    public void readGamesFromFileTest() {
        // Mocking data
        gamesMap = new HashMap<>();
        gamesMap.put("1", new Game("1", "Game 1", "img1", "desc1"));
        gamesMap.put("2", new Game("2", "Game 2", "img2", "desc2"));

        // Stubbing the behavior of the repository mock
        when(gameRepository.getGames()).thenReturn((HashMap<String, Game>) gamesMap);

        // Calling the method under test
        gameService.readGamesFromFile();

        // Assertions
        Assertions.assertEquals(2, gameService.getGames().size());
    }




}
