'use client';

export default function Index() {
  const clickHandler = async () => {
    let a = {};
    await fetch(
      'http://192.168.110.179:8080/backend/users/73791459-9a57-44db-9e83-d870b255588e',
      {
        headers: {
          'Content-Type': 'application/json',
        },
        method: 'GET',
      }
    ).then((res) => (a = res.json()));
    // .then((data) => (a = data));
    console.log(a);
  };
  return (
    <div>
      <button onClick={clickHandler}>Click me</button>
    </div>
  );
}
