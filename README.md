# OO Design
Creating an application to show random popular book quotes from a JSON File.

[Code](src/main/java/) | [Tests](src/test/java/)

## Featured Tasks
Using GSON to parse the .json file (in `assets` folder)

Shows the quote and the author when it ran

Chooses one quote each time it is ran.

## Testing
Clone the repo and cd into this directory.

In the command line type ./gradlew run. This will show a random quote from the json file.




## API
| Class | Method | Description |
| --- | --- | --- |
|`App`| `getJsonFile()` |  Method to read into a JSON file and print an output of a randomly selected author and their respective quote |
| `Authors` | `toString()` | Returns a string value of Authors property `this.author` and `this.text`|
| `App` | `randomGenerator()`|provides a random number index to use |
