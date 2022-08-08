var app = require('http').createServer(response);
var fs = require('fs');
var io = require('socket.io')(app);
var users = [];
var last_messages = [];

app.listen(3000);

console.log("App is running...");
var connectionCounter = 0;



function response(req, res) {
	var file = "";
	if (req.url == "/" && connectionCounter != 2) {
		file = __dirname + '/chat.html';
	} else if (connectionCounter == 2) {
		file = __dirname + '/404.html'
	}
	else {
		file = __dirname + req.url;
	}
	fs.readFile(file,
		function (err, data) {
			if (err) {
				res.writeHead(404);
				return res.end('404 not found');
			}

			res.writeHead(200);
			res.end(data);
		}
	);
}

var counter = 1;

io.on("connection", function (socket) {
	socket.on("enter", function (name, callback) {
		if (!(name in users)) {
			name = "Anonymous" + counter;
			connectionCounter += 1;
			counter += 1;
			socket.name = name;
			users[name] = socket;

			for (indice in last_messages) {
				socket.emit("update message", last_messages[indice]);
			}


			var message = "[ " + getCurrentDate
				() + " ] " + name + " entered the room";
			var obj_message = { msg: message, type: 'system' };

			io.sockets.emit("update users", Object.keys(users));
			io.sockets.emit("update message", obj_message);
			saveMessage(obj_message);

			callback(true);
		} else {
			callback(false);
		}
	});


	socket.on("send message", function (data, callback) {

		var message_sent = data.msg;
		var user = data.usu;
		user = '';
		message_sent = "[ " + getCurrentDate() + " ] " + socket.name + " : " + message_sent;
		var obj_message = { msg: message_sent, tipo: '' };
		io.sockets.emit("update message", obj_message);
		saveMessage(obj_message);
		callback();
	});

	socket.on("disconnect", function () {
		delete users[socket.name];
		var message = "[ " + getCurrentDate() + " ] " + socket.name + " left";
		var obj_message = { msg: message, tipo: 'system' };
		io.sockets.emit("update users", Object.keys(users));
		io.sockets.emit("update message", obj_message);
		connectionCounter -= 1;
		counter -= 1;
		saveMessage(obj_message);
	});

});


function getCurrentDate() {
	var currentDate = new Date();
	var hour = (currentDate.getHours() < 10 ? '0' : '') + currentDate.getHours();
	var minute = (currentDate.getMinutes() < 10 ? '0' : '') + currentDate.getMinutes();
	var second = (currentDate.getSeconds() < 10 ? '0' : '') + currentDate.getSeconds();

	var formatedDate = hour + ":" + minute + ":" + second;
	return formatedDate;
}

function saveMessage(message) {
	if (last_messages.length > 5) {
		last_messages.shift();
	}

	last_messages.push(message);
}