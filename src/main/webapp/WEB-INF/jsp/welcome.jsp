<!DOCTYPE html>
<html>
<body>

<p>Provide a web URL to get a short URL</p>

<input type="text" id="myInput" oninput="myFunction()">

<p id="demo"></p>

<script type="text/javascript">

async function fetchTopFive(sub) {
  // const URL = `https://www.reddit.com/r/javascript/top/.json?limit=5`;

  var webURL = 'http://localhost:8080/' + sub;

  console.log(webURL);

  try {
    const fetchResult = fetch(
      new Request(webURL, { method: 'GET', cache: 'reload' })
    );
    const response = await fetchResult;
    const jsonData = await response.json();
    console.log(jsonData);
  } catch(e){
    throw Error(e);
  }
}


function myFunction() {
    var x = document.getElementById("myInput").value;

    document.getElementById("demo").innerHTML = "" + x;

    fetchTopFive(x);

}
</script>

</body>
</html>