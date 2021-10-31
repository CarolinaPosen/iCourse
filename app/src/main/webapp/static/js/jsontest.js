$('.btn-jsontest').click(function() {
    $.ajax({
        type: "GET",
        url: 'http://localhost:8080/web-app/json2',
        dataType: 'json',
        //data: data,
        success: function (responseData) {
            // this prints out your data
            console.log("successful", responseData);

            responseData.responseType = 'json';

            var teachers = responseData;
            $('#jsonReceiver .ttt').val(teachers);

/*            var idPerson = $(this).attr('data-id-teacher');
            var teacher = $('#teacher'+idPerson);

            var id = responseData['id'];
            $('#jsonReceiver .id').val(id);

            var name = responseData['name']
            $('#jsonReceiver .name').val(name);

            var login = responseData['login'];
            $('#jsonReceiver .login').val(login);

            var password = responseData['password'];
            $('#jsonReceiver .password').val(password);*/

            //window.location.href = "http://localhost:8080/web-app/json";


            const header = document.querySelector('section1');
            const section = document.querySelector('section2');

            var myH1 = document.createElement('h1');
            myH1.textContent = responseData['name'];
            header.appendChild(myH1);

/*            var myPara = document.createElement('p');
            myPara.textContent = 'Name: ' + responseData['name'];
            header.appendChild(myPara);*/

            const heroes = responseData['trainerList'];

            for (var i = 0; i < heroes.length; i++) {
                var myArticle = document.createElement('article');
                var myH2 = document.createElement('h2');
                var myPara1 = document.createElement('p');
                var myPara2 = document.createElement('p');
                var myPara4 = document.createElement('p');
                var myPara3 = document.createElement('p');
                //var myList = document.createElement('ul');

                myH2.textContent = heroes[i].name;
                myPara1.textContent = 'ID: ' + heroes[i].id;
                myPara2.textContent = 'NAME: ' + heroes[i].name;
                myPara4.textContent = 'LOGIN: ' + heroes[i].login;
 //               myPara3.textContent = 'SALARY:';

/*                var superPowers = heroes[i].salary;
                for (var j = 0; j < superPowers.length; j++) {
                    var listItem = document.createElement('li');
                    listItem.textContent = superPowers[j];
                    myList.appendChild(listItem);
                }*/

                myArticle.appendChild(myH2);
                myArticle.appendChild(myPara1);
                myArticle.appendChild(myPara2);
                myArticle.appendChild(myPara4);
                myArticle.appendChild(myPara3);
 //               myArticle.appendChild(myList);

                section.appendChild(myArticle);
            }
        }
    });
});







