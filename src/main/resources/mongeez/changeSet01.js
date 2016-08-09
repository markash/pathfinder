// mongeez formatted javascript

// changeset mpashworth:ChangeSet-1
db.role.insert({
	_id: "Admin", _class: "za.co.yellowfire.threesixty.domain.user.Role",
	_id: "User", _class: "za.co.yellowfire.threesixty.domain.user.Role"
});

//changeset mpashworth:ChangeSet-2
db.user.insert({
	_id: "katie", _class: "za.co.yellowfire.threesixty.domain.user.User", password: "password", role: {_id: "Admin"}, firstName: "Katie", lastName: "Bear" 
});

// changeset mpashworth:ChangeSet-3
db.period.insert({
    start : ISODate("2016-01-01T00:00:00Z"), 
    end   : ISODate("2016-03-31T00:00:00Z")
});

