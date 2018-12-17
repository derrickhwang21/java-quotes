# OO Design & Web Requests
Creating an application to show random popular book quotes from a JSON File.

Grabbing quotes from an API and display those to the user

[Code](src/main/java/) | [Tests](src/test/java/)

## Featured Tasks
Using GSON to parse the .json file (in `assets` folder)

Shows the quote and the author when it ran

Chooses one quote each time it is ran.

Grab quote from Trump API and write into the existing json file

If error occurs when not connected to internet error, a quote from the json file will be displayed instead


## Testing
Clone the repo and cd into this directory.

In the command line type ./gradlew run. This will show a random quote from the json file.




## API
| Class | Method | Description |
| --- | --- | --- |
|`App`| `getJsonFile()` |  Method to read into a JSON file and print an output of a randomly selected author and their respective quote |
| `Authors` | `toString()` | Returns a string value of Authors property `this.author` and `this.text`|
| `App` | `randomGenerator()`|provides a random number index to use |
| `App` | `getTrumpQuote()`|prints and write a trump quote to json file |
| `App` | `addToJson()`|checks existing json file if current value exists, if not, writes object into json file |

